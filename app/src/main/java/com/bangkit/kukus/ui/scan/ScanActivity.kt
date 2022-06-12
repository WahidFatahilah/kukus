package com.bangkit.kukus.ui.scan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bangkit.kukus.databinding.ActivityScanBinding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanBinding
    private var getFile: File? = null
    private lateinit var currentPhotoPath: String

    companion object {
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }


    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBarScan.visibility = View.GONE
        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        binding.ivCamera.setOnClickListener { openCamera() }
        binding.ivGallery.setOnClickListener { openGallery() }
        binding.btnUpload.setOnClickListener { uploadImage() }
        binding.ivBackCamera.setOnClickListener {
            onBackPressed()
        }

    }

    private fun uploadImage() {
        binding.progressBarScan.visibility = View.VISIBLE

        if (getFile != null) {
            val file = reduceFileImage(getFile as File)
            val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                "file",
                file.name,
                requestImageFile
            )

            val service = ApiConfig().getApiService().uploadImage(imageMultipart)

            service.enqueue(object : Callback<FoodImageDataClass> {
                override fun onResponse(
                    call: Call<FoodImageDataClass>,
                    response: Response<FoodImageDataClass>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null && !responseBody.error) {
                            Toast.makeText(
                                this@ScanActivity,
                                "Berhasil upload gambar",
                                Toast.LENGTH_SHORT
                            ).show()
                            binding.progressBarScan.visibility = View.GONE
                            binding.tvFoodName.text = responseBody.foodName
                            binding.tvTotalCalorie.text = "${responseBody.foodCalorie} Kkal"

                            binding.ivAdd.visibility = View.VISIBLE
                            binding.tvAdd.visibility = View.VISIBLE
                            binding.ivAdd.setOnClickListener {
                                val addToDiary = responseBody.foodCalorie.toInt()
                                val konsumsi = Utils.getPreferenceInt(
                                    this@ScanActivity,
                                    Constant.KALORI_DIKONSUMSI
                                )
                                val calculate = addToDiary + konsumsi
                                Utils.putPreferenceInt(
                                    this@ScanActivity,
                                    Constant.KALORI_DIKONSUMSI,
                                    calculate
                                )
                                Toast.makeText(
                                    this@ScanActivity,
                                    "Berhasil ditambahkan ke diary",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } else {
                        Toast.makeText(this@ScanActivity, response.message(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<FoodImageDataClass>, t: Throwable) {
                    //uploadImage()
                    binding.progressBarScan.visibility = View.GONE
                    Toast.makeText(this@ScanActivity, "Gagal mengirim gambar", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        } else {
            binding.progressBarScan.visibility = View.GONE
            Toast.makeText(
                this@ScanActivity,
                "Silakan masukkan berkas gambar terlebih dahulu.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        intent.resolveActivity(packageManager)
        createTempFile(application).also {
            val photoURI: Uri = FileProvider.getUriForFile(
                this@ScanActivity,
                "com.bangkit.kukus",
                it
            )
            currentPhotoPath = it.absolutePath
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            launcherIntentCamera.launch(intent)
        }
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == RESULT_OK) {
            val myFile = File(currentPhotoPath)
            getFile = myFile
            val result = rotateBitmap2(BitmapFactory.decodeFile(myFile.path))
            binding.ivPreview.setImageBitmap(result)
        }
    }

    private fun openGallery() {
        binding.tvFoodName.text = "-"
        binding.tvTotalCalorie.text = "-"
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Silahkan pilih gambar")
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = uriToFile(selectedImg, this@ScanActivity)
            getFile = myFile

            binding.ivPreview.setImageURI(selectedImg)
        }
    }

    private fun openCameraX() {
        binding.tvFoodName.text = "-"
        binding.tvTotalCalorie.text = "-"
        val intent = Intent(this, CameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean

            getFile = myFile
            val result = rotateBitmap(
                BitmapFactory.decodeFile(myFile.path),
                isBackCamera
            )
            binding.ivPreview.setImageBitmap(result)
        }
    }
}
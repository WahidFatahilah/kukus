package com.bangkit.kukus.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.FragmentMainContentBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils.getPreferenceInt
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel


class MainFragmentContent : Fragment() {

    private lateinit var binding: FragmentMainContentBinding
    private lateinit var dietRecAdapter: HomeAdapter1
    private lateinit var healthyRecAdapter: HomeAdapter2
    private lateinit var exerciseRecAdapter: HomeAdapter3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainContentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageSlider = binding.imgImageSlider
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.img_slider1))
        imageList.add(SlideModel(R.drawable.img_slider2))
        imageList.add(SlideModel(R.drawable.img_slider3))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                val intent = Intent(requireContext(), OnClickArticleActivity::class.java)
                intent.putExtra(OnClickArticleActivity.EXTRA_POSITION, position)
                startActivity(intent)
            }
        })

        dietRecAdapter = HomeAdapter1()
        dietRecAdapter.setData(DummyRvHome.generateDataDummy1())
        binding.rvDietRecomm.adapter = dietRecAdapter


        dietRecAdapter.onItemClick = {
            val intent = Intent(
                requireActivity() as AppCompatActivity,
                OnClickedDietPlanActivity::class.java
            )
            intent.putExtra(OnClickedDietPlanActivity.EXTRA_DATA, it)
            startActivity(intent)
        }

        healthyRecAdapter = HomeAdapter2()
        healthyRecAdapter.setData(DummyRvHome.generateDataDummy2())
        binding.rvFoodRecom.adapter = healthyRecAdapter

        healthyRecAdapter.onItemClick = {
            val intent = Intent(
                requireActivity() as AppCompatActivity,
                OnClickedHealthyFoodActivity::class.java
            )
            intent.putExtra(OnClickedHealthyFoodActivity.EXTRA_DATA, it)
            startActivity(intent)
        }

        exerciseRecAdapter = HomeAdapter3()
        exerciseRecAdapter.setData(DummyRvHome.generateDataDummy3())
        binding.rvExerciseRecom.adapter = exerciseRecAdapter

        exerciseRecAdapter.onItemClick = {
            val intent = Intent(
                requireActivity() as AppCompatActivity,
                OnClickedExerciseActivity::class.java
            )
            intent.putExtra(OnClickedExerciseActivity.EXTRA_DATA, it)
            startActivity(intent)
        }
        var dikonsumsi = getPreferenceInt(requireContext(), Constant.KALORI_DIKONSUMSI)
        var dibakar = getPreferenceInt(requireContext(), Constant.KALORI_DIBAKAR)
        var kaloriHarian = getPreferenceInt(requireContext(), Constant.KALORI_HARIAN)
        val calculate = kaloriHarian - dikonsumsi

        binding.tvTittleBurned.text = dibakar.toString()
        binding.tvTittleConsumed.text = dikonsumsi.toString()
        binding.tvTittleCalorie.text = calculate.toString()

    }
}
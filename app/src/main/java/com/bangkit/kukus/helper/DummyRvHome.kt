package com.bangkit.kukus.helper

import android.os.Parcelable
import com.bangkit.kukus.R
import kotlinx.parcelize.Parcelize

object DummyRvHome {
    @Parcelize
    data class Dummy1(
        var nama: String,
        var img: String,
        var description: String,
        var dos: String,
        var donts: String
    ) : Parcelable

    @Parcelize
    data class Dummy2(
        var nama: String,
        var img: String,
        var gizi: Int,
        var bahan: String,
        var resep: String
    ) : Parcelable

    @Parcelize
    data class Dummy3(
        var nama: String,
        var img: String,
        var kalori: String,
        var durasi: String,
        var alat: String,
        var persiapan: String,
        var video: String
    ) : Parcelable

    @Parcelize
    data class Dummy4(
        var nama: String,
        var img: Int,
        var description: String,
    ) : Parcelable

    @Parcelize
    data class DummyRvArticle(
        var nama: String,
        var img: String
    ) : Parcelable

    @Parcelize
    data class DummyRvDiet(
        var nama: String,
        var img: String
    ) : Parcelable

    fun generateDataDummy1(): ArrayList<Dummy1> {
        val categories = ArrayList<Dummy1>()
        categories.clear()

        categories.add(
            Dummy1(
                "Mediterranean Diet",
                "https://i0.wp.com/post.healthline.com/wp-content/uploads/2020/09/mediterranean-diet-meal-plan-732x549-thumbnail.jpg?w=1575",
                "   Mediterranean diet merupakan diet yang hanya meliputi makanan tradisional Batasan laut Mediterranean (Prancis, Spanyol, Yunani, dan Italia). Diet ini fokus untuk mencegah berbagai penyakit atau gejala, seperti serangan jantung, struk, diabetes, atau bahkan kagnker. Selain itu, banyak orang yang juga melaporkan turunnya berat badan dengan mengikuti diet ini.\n" +
                        "\n" +
                        "   Diet ini secara umum lebih meliputi buah-buahan, biji-bijian, seafood, dan produk susu seperti keju dan yogurt. Namun, diet ini tidak terlalu ketat dengan bahan makanan yang anda gunakan. Daging merah, gula, dan makanan yang telah diproses pun boleh anda makan, tapi tidak boleh sering-sering. Bahan makanan dari unggas seperti telur dan daging ayam pun perlu dibatasi, namun bukan yang utama untuk dibatasi.\n",
                "• Sarapan dengan makanan ringan, seperti yogurt dan roti saja\n" +
                        "\n• Memakan cemilan berupa kacang-kacangan\n" +
                        "\n• Sesekali menambah telur atau daging ayam untuk menambah kadar protein",
                "• Membeli beberapa menu fast food untuk makan dalam waktu apapun\n" +
                        "\n• Memakan nasi putih yang melebihi setengah piring setiap makan"
            )
        )

        categories.add(
            Dummy1(
                "Clean Bulking Diet",
                "https://i0.wp.com/post.healthline.com/wp-content/uploads/2020/02/athletic-man-eating-smoothie-shake-home-1296x728-header-1296x728.jpg?w=1575",
                "  Clean bulking merupakan rencana diet untuk menambah berat badan dengan calorie surplus (memakan kalori lebih banyak daripada membakarnya). Diet ini merupakan rencana yang utama digunakan oleh atlet olahraga untuk membuat badan lebih sehat dan membangun otot yang lebih bagus. Dengan diet ini, anda tidak hanya akan menambah berat badan saja, namun juga membuat bentuk badan yang lebih bagus dengan makanan sehat.\n" +
                        "\n  Proses menambah berat badan dengan diet ini akan terasa lambat, namun pilihan makanan sehatnya akan menghasilkan badan yang sehat. Makanan yang anda akan utamakan untuk dimakan adalah apapun yang mengandung protein banyak, seperti telur, daging, tahu dan tempe, dan bahkan keju atau yogurt. Makanan yang mengandung karbohidrat dan lemak sehat juga dibutuhkan sesekali, seperti nasi, kentang, dan minyak zaitun.\n" + "\n   Minuman utama diet ini merupakan air mineral saja, namun kopi dan teh sesekali juga boleh. Yang perlu dihindari sebanyak mungkin adalah makanan dan minuman yang telah diproses dan makanan yang berkadar berlebihan, seperti fast food, daging berlemak, soda, es krim, dan berbagai jenis minyak.",
                "• Memulai hari dengan sarapan dengan pisang saja dan makan siang yang cukup banyak dengan nasi ayam hasil masak\n" +
                        "\n• Mengkonsumsi protein powder sebelum berolahraga\n" +
                        "\n• Sesekali memakan fast food dalam keadaan darurat",
                "• Memakan cemilan burger dari delivery\n" +
                        "\n• Makan terlalu banyak yang mempersulit olahraga\n" +
                        "\n• Memilih soda dibandingkan air mineral supaya menambah kalori"
            )
        )

        categories.add(
            Dummy1(
                "Volumetrics Diet",
                "https://i0.wp.com/post.healthline.com/wp-content/uploads/2020/08/healthy-food-vegetables-1296x728-header.jpg?w=1155&h=1528",
                "   Masalah umum yang paling sering dihadapi oleh orang yang melakukan diet adalah mengurangi jumlah makanan yang dapat menyebabkan kurangnya energi yang masuk ke dalam tubuh sehingga tubuh menjadi lemas dan tidak bertenaga. Tahukan kamu ada cara diet yang cukup ampuh akan tetapi jumlah makanan yang dimakan tetap bisa membuat kita kenyang? Mari bekenalan dengan volumetrics Diet\n" +
                        "\n   Volumetrics Diet adalah sebuah skema makan yang teratur dengan memperhitungkan densitas energi. Diet ini diperkenalkan oleh Barbara Rolls, PhD. Jadi pada dasarkan Ketika kita sedang diet, kita dapat memakan makanan apapun, akan tetapi yang diperhitungkan adalah jumlah energi yang terkandung di dalam makanan tersebut atau disebut densitas energi. Umumnya densitas energi dikenal sebagai kalori yang terkandung dalam sebuah makanan yang dikonsumsi. \n" +
                        "\n   Suatu makanan dapat memiliki densitas yang berbeda, sebagai contoh makana yang mengandung densitas energi tinggi adalah makanan-makanan berminyak atau makanan-makanan yang digoreng. Contoh lain makanan yang memiliki densitas rendah adalah makanan seperti sayur dan buah sehingga untuk mencapai kalori yang ditentukan, dibutuhkan jumlah atau volume yang lebih banyak untuk makanan-makanan yang berkalori rendah mencapai target kalori. \n",
                "• Konsumsi makanan dengan kalori yang rendah. Beberapa contoh makanan dengan kategori rendah adalah buah, sayur, dan sup kaldu (sayur bening)\n" +
                        "\n• Lakukan olahraga rutin \n" +
                        "\n• Atur kalori yang ingin dicapai dan hitung kalori setiap makanan yang dikonsumsi\n",
                "• Jangan memakan makanan yang mengandung kalori tinggi seperti makanan berminyak dan makanan yang digoreng. \n" +
                        "\n• Hindari memakan makanan yang mengandung gula tinggi serperti permen, biscuit dan makanan-makanan yang berlemak\n" +
                        "\n• Jangan mengonsumsi makanan melebihi aturan kalori yang sudah ditetapkan.\n"
            )
        )
        return categories
    }

    fun generateDataDummy2(): ArrayList<Dummy2> {
        val categories = ArrayList<Dummy2>()
        categories.clear()

        categories.add(
            Dummy2(
                "Steak Tempe",
                "https://cdn-brilio-net.akamaized.net/news/2020/11/10/195237/1349081-1000xauto-resep-diet-makan-siang.jpg",
                R.drawable.img_chart_steaktempe,
                "• 100 gram tempe (Cooked)\n" +
                        "• 3 gram lada putih\n" +
                        "• 10 gram tepung maizena\n" +
                        "• Minyak Kelapa\n" +
                        "• 6 siung bawang putih, potong kecil\n" +
                        "• 1/2 siung bombay, iris sesuai selera\n" +
                        "• 2 buah tomat, haluskan\n" +
                        "• 2 sdm garam\n" +
                        "• Kecap manis organic secukupnya\n" +
                        "• Lada hitam utuh, ulek kasar\n" +
                        "• Gula aren sesuai selera\n" +
                        "• 30 ml air\n",
                "1. Potong tempe, kemudian kukus tempe hingga matang. Lalu haluskan.\n" +
                        "\n2. Haluskan bawang putih, lalu campur dengan tempe yang sudah dikukus. Tambahkan pula tepung maizena, garam, dan lada putih kemudian aduk hingga merata. Bentuk adonan dapat bervariatif, menyesuaikan selera.\n" +
                        "\n3. Masak (grill) tempe hingga matang, sesekali bolak-balik tempenya, namun jangan terlalus erring agar tempe tidak hancur. Angkat lalu sisihkan.\n" +
                        "\n4. Saus: Tumis bawang putih hingga harum lalu kemudian masukkan bawang bombay hingga layu. Masukkan semua bahan saus serta lada dan masak hingga mendidih. Tambahkan air atau garam jika perlu. Aduk hingga merata. Sajikan pada tempe yang sudah dimasak sebelumnya.\n"
            )
        )

        categories.add(
            Dummy2(
                "Cream Soup",
                "https://cdn-brilio-net.akamaized.net/news/2020/11/10/195237/1349077-1000xauto-resep-diet-makan-siang.jpg",
                R.drawable.img_chart_creamsoup,
                "• 100 gram tempe (Cooked)" +
                        "\n• 3 gram lada putih" +
                        "\n• 10 gram tepung maizena" +
                        "\n• Minyak Kelapa" +
                        "\n• 6 siung bawang putih, potong kecil" +
                        "\n• 1/2 siung bombay, iris sesuai selera" +
                        "\n• 2 buah tomat, haluskan" +
                        "\n• 2 sdm garam" +
                        "\n• Kecap manis organic secukupnya" +
                        "\n• Lada hitam utuh, ulek kasar" +
                        "\n• Gula aren sesuai selera" +
                        "\n• 30 ml air" +
                        "\n• 200 gram ayam fillet" +
                        "\n• buah wortel, potong dadu kecil" +
                        "\n• 2 siung bawang putih dicincang halus" +
                        "\n• 300 ml susu cair" +
                        "\n• 400 ml air" +
                        "\n• Bawang bombay, potong dadu" +
                        "\n• 4 buah bakso, potong dadu" +
                        "\n• 4 sdm tepung terigu + 100 ml air" +
                        "\n• 1 sdt lada bubuk" +
                        "\n• Garam secukupnya",
                "1. Rebus ayam fillet hingga empuk, lalu kemudian angkat dan tiriskan. Potong ayam fillet seperlunya atau sesuai selera.\n" +
                        "\n2. Rebus wortel hingga empuk di kuah ayam.\n" +
                        "\n3. Tumis bawang putih dan bawang bombay. Campurkan susu, garam, dan lada kemudian masak hingga mendidih.\n" +
                        "\n4. Campur ke panci kuah hasil rebusan ayam, tambahkan lagi potongan ayam, bakso, lalu aduk hingga merata.\n" +
                        "\n5. Tambahkan terigu, kemudian masak hingga menjadi sedikit kental.\n"
            )
        )

        categories.add(
            Dummy2(
                "Omelete Sayur",
                "https://cdn0-production-images-kly.akamaized.net/fHMsfoauNewWGU4gK1SbSRX--TY=/0x247:999x810/680x383/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3562410/original/065659300_1630902607-shutterstock_1448875190.jpg",
                R.drawable.img_chart_creamsoup,
                "• 3 butir telur" +
                        "\n• 1 buah tomat" +
                        "\n• Brokoli secukupnya" +
                        "\n• Segenggam bayam" +
                        "\n• Jamur secukupnya" +
                        "\n• 1 buah wortel" +
                        "\n• Olive oil" +
                        "\n• Garam secukupnya\n",
                "1. Cuci bersih sayuran dengan air mengalir. Potong-potong semua sayuran sesui dengan keinginan.\n" +
                        "\n2. Kocok lepas telur dan tambahkan sejumput garam.\n" +
                        "\n3. Tambahkan semua sayuran yang telah dipotong.\n" +
                        "\n4. Kemudian panaskan olive oil ke dalam teflon.\n" +
                        "\n5. Tuangkan adonan telur ke dalam teflon. Masak hingga matang.\n" +
                        "\n6. Omelet sayur siap disajikan.\n"
            )
        )
        return categories
    }


    fun generateDataDummy3(): ArrayList<Dummy3> {
        val categories = ArrayList<Dummy3>()
        categories.clear()

        categories.add(
            Dummy3(
                "Lompat Tali",
                "https://statik.tempo.co/data/2021/02/25/id_1003186/1003186_720.jpg",
                "750 Kalori",
                "45 Menit",
                "Tali Skipping",
                "1. Memilih tali yang tepat.\n" +
                        "\n2. Tali dengan panjang sampai ke bahu ketika dilipat dua. Tali sepanjang itu sudah cukup untuk bisa dilompati dengan nyaman tanpa membuat kaki kita tersandung.\n" +
                        "\n3. Tali harus memiliki pegangan yang mudah digenggam, dan tidak terlalu berat atau terlalu ringan.\n",
                "https://storage.googleapis.com/exercise-videos-kukus/Lompat%20Tali.mp4"
            )
        )

        categories.add(
            Dummy3(
                "Lari Pagi",
                "https://res.cloudinary.com/dk0z4ums3/image/upload/v1633395347/attached_image/manfaat-lari-pagi-untuk-menurunkan-berat-badan-0-alodokter.jpg",
                "400 Kalori",
                "30 Menit",
                "Botol Air dan Sepatu",
                "1. Sarapan dengan makanan yang mengandung protein dan karbohidrat\n" +
                        "\n2. pemanasan dan peregangan sekitar 5 menit sebelum berlari.\n" +
                        "\n3. Kenakan sepatu lari yang nyaman dan kuat serta pas dengan ukuran kaki Anda.\n" +
                        "\n4. Kenakanlah pakaian yang nyaman\n" +
                        "\n5. Siapkan air minum, baik air putih atau minuman isotonik, untuk mencegah dehidrasi.\n",
                "https://storage.googleapis.com/exercise-videos-kukus/Lari%20Pagi.mp4"
            )
        )

        categories.add(
            Dummy3(
                "Plank",
                "https://image-cdn.medkomtek.com/BgM2gf7qHnpNe2Y_GbBN32fET78=/673x379/smart/klikdokter-media-buckets/medias/2316816/original/025884900_1595239998-Sederet-Manfaat-Plank-bagi-Tubuh-Anda-shutterstock_1418433089.jpg",
                "2-5 Kalori/Menit",
                "20 Detik/Sesi",
                "Matras",
                "1. Berbaring telungkup di matras\n" +
                        "\n2. Angkat tubuh anda sehingga bertumpu pada lengan bawah\n" +
                        "\n3. Posisikan dengan nyaman siku di bawah lengan\n",
                "https://storage.googleapis.com/exercise-videos-kukus/Plank.mp4"
            )
        )
        return categories
    }

    fun generateDataDummy4(): ArrayList<Dummy4> {
        val categories = ArrayList<Dummy4>()
        categories.clear()

        categories.add(
            Dummy4(
                "Apakah diet ala artis korea IU efektif?",
                R.drawable.img_slider1,
                "Diet IU adalah pola makan yang dilakukan oleh artis K-Pop tersebut dengan menu yang terbilang nyeleneh. Betapa tidak, dalam sehari, IU hanya boleh sarapan dengan satu butir apel, makan siang dengan dua butir ubi, dan makan malam dengan menenggak segelas susu protein. Diet ini dilakukan minimal 3 hari, tetapi IU menjalaninya hingga satu minggu. \n" +
                        "\nHasilnya, pemeran utama dalam film seri Hotel Del Luna itu dapat menurunkan berat badan hingga 5 kg hanya dalam tempo satu minggu tersebut. Penurunan berat badan yang sangat drastis tersebut sebetulnya bukanlah keajaiban. Pasalnya, total kalori yang masuk ke tubuh IU dalam sehari hanyalah sekitar 500 kalori, sedangkan wanita dewasa pada umumnya membutuhkan 1.500-3.000 kalori dalam sehari. Ahli gizi menyatakan, diet ala IU ini sebetulnya sah-sah saja dilakukan selama hanya dalam jangka waktu pendek. \n" +
                        "\nNamun, bila dilakukan secara terus-menerus, diet dengan defisit kalori yang terlalu jauh justru akan membahayakan tubuh. IU sendiri memang mengakui hanya melakukan diet ini untuk keperluan syuting atau konser saja, itu pun dilakukannya dengan menahan berbagai rasa tidak nyaman pada tubuhnya. Jadi, jika kamu ingin menirunya, sebaiknya berkonsultasi terlebih dahulu dengan dokter sebelum menjalani diet ala IU ini.\n" +
                        "\nMengurangi asupan makanan yang mengandung karbohidrat memang banyak direkomendasikan saat ingin menurunkan berat badan. Namun, perubahan yang sangat drastis dalam pola makan akan mengubah metabolisme karena karbohidrat adalah salah satu sumber energi yang dibutuhkan oleh tubuh.",
            )
        )

        categories.add(
            Dummy4(
                "Bahaya melewatkan sarapan",
                R.drawable.img_slider2,
                "1. Meningkatkan risiko masalah jantung\n" +
                        "Melewatkan sarapan ternyata dapat memberi dampak pada salah satu organ vital pada tubuh manusia yaitu jantung. Berdasarkan studi yang dilakukan Universitas Harvard, laki-laki yang melewatkan sarapan memiliki risiko 27 persen lebih besar terkena serangan jantung daripada mereka yang mempunyai kebiasaan selalu sarapan.\n" +
                        "\nSeperti kita ketahui, jantung merupakan salah satu organ vital terpenting bagi tubuh manusia. Mulai sekarang, jangan pernah lewatkan sarapan lagi agar keadaan jantung kamu tetap sehat dan aman.\n" +
                        "\n2. Meningkatkan risiko obesitas\n" +
                        "Banyak yang melewatkan sarapan dengan dalih sedang diet atau berniat mengurangi berat badan. Padahal, kenyataan yang terjadi dapat sebaliknya. Melewatkan sarapan dapat meningkatkan risiko obesitas atau kelebihan berat badan. \n" +
                        "\nBerdasarkan studi dari salah satu jurnal Arab Journal of Nutrition and Excercise, melewatkan sarapan dapat dikaitkan dengan risiko obesitas atau kelebihan berat badan pada anak-anak dan usia remaja.\n" +
                        "\n3. Meningkatkan hormon kortisol\n" +
                        "Hormon kortisol merupakan hormon stres yang dapat memicu terjadi stres pada seseorang. Semakin tinggi hormon kortisol dalam tubuh seseorang, semakin tinggi pula kadar stres yang akan dialami. \n" +
                        "\nBerdasarkan studi dari University of California, wanita yang melewatkan sarapan pagi memiliki kadar kortisol yang lebih tinggi dibanding mereka yang menyempatkan diri untuk sarapan. Selain itu, wanita yang melewatkan sarapan juga cenderung memiliki tekanan darah yang lebih tinggi.\n",
            )
        )

        categories.add(
            Dummy4(
                "Tidak makan nasi bikin cepat kurus?",
                R.drawable.img_slider3,
                "1. Yogurt\n" +
                        "Kedepankan menu-menu tinggi kalsium termasuk yogurt demi memangkas lemak perut. Mengutip dari Best Health Magazine, sebuah tinjauan terhadap lebih dari 90 studi mengungkapkan hubungan kuat antara kalsium yang tinggi dan peningkatan komposisi tubuh.\n" +
                        "\n" +
                        "Tinjauan yang diterbitkan di jurnal Nutrition Reviews ini menyebut saat kalsium rendah, tubuh akan mengeluarkan hormon yang memungkinkan Anda memanfaatkan kalsium yang ada dengan lebih baik. Akan tetapi, secara bersamaan, tubuh memberikan sinyal pada sel-sel lemak untuk menahan lemak, termasuk lemak perut.\n" +
                        "\n2. Alpukat\n" +
                        "Alpukat adalah salah satu sumber lemak sehat yang dibutuhkan tubuh. Mengutip CBS News, lemak jenuh tunggal yang ada di dalam alpukat dapat menghentikan lonjakan gula darah yang memberikan sinyal ke tubuh untuk menyimpan lemak di sekitar perut.\n" +
                        "\n" +
                        "Tidak hanya itu, lemak sehat dari alpukat juga akan membantu mencegah perut kembung dan menyerap karotenoid lebih baik. Karotenoid merupakan senyawa yang bisa melawan kanker.\n" +
                        "\n" +
                        "3. Telur\n" +
                        "Cara klasik yang terbukti dapat menurunkan lemak adalah mencukupi kebutuhan protein. Tubuh memerlukan lebih banyak kalori untuk memecah protein daripada memecah makanan lain. Protein juga membantu menjaga massa otot saat Anda menurunkan berat badan. Selain itu, protein memberikan rasa kenyang lebih lama daripada karbohidrat."

            )
        )
        return categories
    }

    fun generateDataRvArticle(): ArrayList<DummyRvArticle>{
        val categories = ArrayList<DummyRvArticle>()
        categories.clear()

        categories.add(
            DummyRvArticle(
                "Gak Makan Nasi Bikin Cepat Kurus? Ternyata Mitos!",
                "https://i.ytimg.com/vi/R39NMFIDhS0/maxresdefault.jpg"
            )
        )

        categories.add(
            DummyRvArticle(
                "Efek Obat Penurun Berat Badan atau Pelangsing",
                "https://www.siswapedia.com/wp-content/uploads/2019/10/Efek-Obat-Penurun-Berat-Badan-atau-Pelangsing.png"
            )
        )

        categories.add(
            DummyRvArticle(
                "Manfaat Buah dan Sayur dari Warnanya",
                "https://indonesiabaik.id/public/uploads/post/5098/5098-1627944520-210802_EI_Manfaat-Buah-dan-Sayur-dari-Warnanya_AB.jpg"
            )
        )
        return categories
    }

    fun generateDataRvDiet(): ArrayList<DummyRvDiet> {
        val categories = ArrayList<DummyRvDiet>()
        categories.clear()

        categories.add(
            DummyRvDiet(
                "Bran flakes",
                "https://www.usnews.com/object/image/00000151-ef51-d422-ad79-fff5178c0000/151229-branflakes-stock.jpg?update-time=1451419121303&size=responsive230"
            )
        )

        categories.add(
            DummyRvDiet(
                "Veggie hash with eggs",
                "https://www.usnews.com/object/image/0000016a-6f78-d436-a5eb-fffcb2f60000/veggiehasheggs.jpg?update-time=1556648410334&size=responsive230"
            )
        )

        categories.add(
            DummyRvDiet(
                "Skinless poultry",
                "https://www.usnews.com/object/image/00000152-0e05-d42e-a5f2-4f0f081e0000/160104-turkeybreastsalad-stock.jpg?update-time=1451934216809&size=responsive230"
            )
        )
        return categories
    }
}
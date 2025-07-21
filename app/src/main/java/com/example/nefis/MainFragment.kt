package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.example.nefis.R

class MainFragment : BrowseSupportFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = ""  // Eliminamos el título por defecto
        brandColor = resources.getColor(R.color.color_rosa, null)

        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Reemplazar el título por uno personalizado
        val titleGroupId = resources.getIdentifier("browse_title_group", "id", requireActivity().packageName)
        val titleView = view.findViewById<View>(titleGroupId)

        val parent = titleView?.parent as? ViewGroup
        val index = parent?.indexOfChild(titleView) ?: -1

        if (index != -1 && parent != null) {
            parent.removeViewAt(index)
            val customTitle = LayoutInflater.from(context).inflate(R.layout.custom_title, parent, false)
            parent.addView(customTitle, index)
        }

        val categories = ArrayObjectAdapter(ListRowPresenter())

        val animalesMarinos = ArrayObjectAdapter(Card())
        animalesMarinos.addAll(0, listOf(
            Video("Medusa", "Animal", R.mipmap.medusa1, "Animal marino MEDUSA", R.raw.video1),
            Video("Peces", "Animal", R.mipmap.peces1, "Animal marino PECES", R.raw.peces1),
            Video("Tortuga", "Animal", R.mipmap.tortuga1, "Animal marino TORTUGA", R.raw.tortuga1),
            Video("Pulpo", "Animal", R.mipmap.pulpo1, "Animal marino PULPO", R.raw.pulpo1),
            Video("Mantarraya", "Animal", R.mipmap.mantarraya1, "Animal marino MANTARRAYA", R.raw.mantarraya1)
        ))
        categories.add(ListRow(HeaderItem(0, "Animales marinos"), animalesMarinos))

        val arteVideos = ArrayObjectAdapter(Card())
        arteVideos.addAll(0, listOf(
            Video("Baile", "Expresiones artísticas", R.mipmap.ballet2, "Baile de BALLET", R.raw.ballet2),
            Video("Música", "Expresión musical", R.mipmap.piano2, "Música de Piano", R.raw.piano2),
            Video("Pintura", "Pintura artística", R.mipmap.pintura2, "Expresión artística en pintura", R.raw.arte2),
            Video("Sentimiento", "Sentimientos puros", R.mipmap.rosa2, "Sentimientos puros y delicados", R.raw.rosas2),
            Video("Belleza", "Apreciar la belleza", R.mipmap.belleza2, "Apreciación de la belleza", R.raw.belleza2)
        ))
        categories.add(ListRow(HeaderItem(1, "Arte"), arteVideos))

        val perritosVideos = ArrayObjectAdapter(Card())
        perritosVideos.addAll(0, listOf(
            Video("Salchicha", "Perritos bebés", R.mipmap.perrito3, "Perrito salchicha", R.raw.perrito3),
            Video("Shitzu", "Perritos bebés", R.mipmap.shitzu3, "Perrito shitzu", R.raw.shitzu3),
            Video("Golden Retriever", "Perritos bebés", R.mipmap.golden, "Perrito golden", R.raw.golden),
            Video("Pastor Alemán", "Perritos bebés", R.mipmap.perrito4, "Perrito pastor alemán", R.raw.aleman),
            Video("Pomerania", "Perritos bebés", R.mipmap.pomerania, "Perrito pomerania", R.raw.pomerania)
        ))
        categories.add(ListRow(HeaderItem(2, "Perritos"), perritosVideos))

        val gatitosVideos = ArrayObjectAdapter(Card())
        gatitosVideos.addAll(0, listOf(
            Video("Gatito 1", "Gatitos activos", R.mipmap.gato1, "Tiernos", R.raw.g1),
            Video("Gatito 2", "Gatitos activos", R.mipmap.gato2, "Lindos", R.raw.g2),
            Video("Gatito 3", "Gatitos activos", R.mipmap.gato3, "Cariñosos", R.raw.g3),
            Video("Gatito 4", "Gatitos activos", R.mipmap.gato4, "Curiosos", R.raw.g4),
            Video("Gatito 5", "Gatitos activos", R.mipmap.gato5, "Amorosos", R.raw.g5)
        ))
        categories.add(ListRow(HeaderItem(3, "Gatitos"), gatitosVideos))

        val bebesVideos = ArrayObjectAdapter(Card())
        bebesVideos.addAll(0, listOf(
            Video("Bebé 1", "Travesura", R.mipmap.b1, "Travesura", R.raw.b1),
            Video("Bebé 2", "Ternura", R.mipmap.b2, "Ternura", R.raw.b2),
            Video("Bebé 3", "Cariño", R.mipmap.b3, "Cariño", R.raw.b3),
            Video("Bebé 4", "Amorosos", R.mipmap.b4, "Amorosos", R.raw.b4),
            Video("Bebé 5", "Maternidad", R.mipmap.b5, "Maternidad", R.raw.b5)
        ))
        categories.add(ListRow(HeaderItem(4, "Bebés"), bebesVideos))

        adapter = categories

        onItemViewClickedListener = OnItemViewClickedListener { _, video, _, _ ->
            val intent = Intent(requireContext(), PlayActivity::class.java).apply {
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}

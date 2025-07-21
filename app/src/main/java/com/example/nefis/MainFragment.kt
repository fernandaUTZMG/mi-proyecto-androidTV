package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class MainFragment : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = "Netflix "

        val categories = ArrayObjectAdapter(ListRowPresenter())

        // === CATEGORÍA 1: ANIMALES MARINOS===
        val nutellaVideos = ArrayObjectAdapter(Card())
        nutellaVideos.addAll(0, listOf(
            Video("Medusa", "Animal", R.mipmap.medusa1, "Animal marino MEDUSA", R.raw.video1),
            Video("Peces", "Animal", R.mipmap.peces1, "Animal marino PECES", R.raw.peces1),
            Video("Tortuga", "Animal", R.mipmap.tortuga1, "Animal marino TORTUGA", R.raw.tortuga1),
            Video("Pulpo", "Animal", R.mipmap.pulpo1, "Animal marino PULPO", R.raw.pulpo1),
            Video("Mantarraya", "Animal", R.mipmap.mantarraya1, "Animal marino MANTARRAYA", R.raw.mantarraya1),
        ))
        categories.add(ListRow(HeaderItem(0, "Animales marinos"), nutellaVideos))


        // === CATEGORÍA 2: ARTE ===
        val mandarinoVideos = ArrayObjectAdapter(Card())
        mandarinoVideos.addAll(0, listOf(
            Video("Baile", "Expresiones artisticas", R.mipmap.ballet2, "Baile de BALLET", R.raw.ballet2),
            Video("Musica", "Expresion musical", R.mipmap.piano2, "Musica de Piano", R.raw.piano2),
            Video("Pintura", "Pintura artistica", R.mipmap.pintura2, "Expresion artistica en pintura", R.raw.arte2),
            Video("Sentimiento", "sentimiento puro", R.mipmap.rosa2, "Sentimentos puros y delicados", R.raw.rosas2),
            Video("Belleza", "Apreciar la belleza", R.mipmap.belleza2, "Apreciacion de la belleza", R.raw.belleza2),
        ))
        categories.add(ListRow(HeaderItem(1, "Arte"), mandarinoVideos))

        // === CATEGORÍA 3: PERRITOS ===
        val peluchesVideos = ArrayObjectAdapter(Card())
        peluchesVideos.addAll(0, listOf(
            Video("SALCHICHA", "perritos bebes", R.mipmap.perrito3, "Perrito salchicha", R.raw.perrito3),
            Video("SHITZU", "perritos bebes", R.mipmap.shitzu3, "Perrito shitzu", R.raw.shitzu3),
            Video("GOLDEN RETRIEVER", "perritos bebes", R.mipmap.golden, "Perrito golden", R.raw.golden),
            Video("PASTOR ALEMAN", "perritos bebes", R.mipmap.perrito4, "Perrito pastor aleman", R.raw.aleman),
            Video("POMERANIA 5", "perritos bebes", R.mipmap.pomerania, "Perrito pomerania", R.raw.pomerania),
        ))
        categories.add(ListRow(HeaderItem(2, "Perritos"), peluchesVideos))

        // === CATEGORÍA 4: Animales ===
        val animalesVideos = ArrayObjectAdapter(Card())
        animalesVideos.addAll(0, listOf(
            Video("Gatitos", "Gatitos activos", R.mipmap.gato1, "tiernos", R.raw.g1),
            Video("Gatitos", "Gatitos activos", R.mipmap.gato2, "lindos", R.raw.g2),
            Video("Gatitos", "Gatitos activos", R.mipmap.gato3, "cariñosos", R.raw.g3),
            Video("Gatitos", "Gatitos activos", R.mipmap.gato4, "curiosos", R.raw.g4),
            Video("Gatitos", "Gatitos activos", R.mipmap.gato5, "amororosos", R.raw.g5),
        ))
        categories.add(ListRow(HeaderItem(3, "Gatitos"), animalesVideos))

        // === CATEGORÍA 5: Gatitos ===
        val gatitosVideos = ArrayObjectAdapter(Card())
        gatitosVideos.addAll(0, listOf(
            Video("Bebes 1", "Trabesura", R.mipmap.b1, "Trabesura", R.raw.b1),
            Video("Bebes 2", "Ternura", R.mipmap.b2, "Ternura", R.raw.b2),
            Video("Bebes 3", "Cariño", R.mipmap.b3, "Cariño", R.raw.b3),
            Video("Bebes 4", "Amorosos", R.mipmap.b4, "Amorosos", R.raw.b4),
            Video("Bebes 5", "Maternidad", R.mipmap.b5, "Maternidad", R.raw.b5),
        ))
        categories.add(ListRow(HeaderItem(4, "Bebes"), gatitosVideos))

        // Asignar al adaptador
        adapter = categories

        // Listener para abrir PlayActivity
        onItemViewClickedListener = OnItemViewClickedListener { _, video, _, _ ->
            val intent = Intent(requireContext(), PlayActivity::class.java).apply {
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}

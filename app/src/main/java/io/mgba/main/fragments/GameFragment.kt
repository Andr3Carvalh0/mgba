package io.mgba.main.fragments

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.mgba.main.adapters.GameAdapter
import io.mgba.R
import io.mgba.data.local.model.Game
import io.mgba.ui.fragments.interfaces.IGamesFragment
import io.mgba.ui.views.GameInformationView
import io.mgba.mgba
import kotlinx.android.synthetic.main.games_list_view.*

open class GameFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener{
    private lateinit var adapter: GameAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return prepareView(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       /* super.onViewCreated(view, savedInstanceState)
        if(arguments == null)
            mgba.report(Exception("Game Fragment creation failed because args are null"))

        val platform = arguments!!.getInt(Constants.ARG_PLATFORM)
        controller = GamesPresenter(platform, this)

        prepareDrawables()
        prepareRecyclerView()

        if (savedInstanceState != null) {
            list.layoutManager!!
                    .onRestoreInstanceState(savedInstanceState.getParcelable<Parcelable>(Constants.MAIN_RECYCLER_CONTENT))
        }

        showContent(false)
        loadGames()*/
    }

    private fun prepareRecyclerView() {
/*        main_refresh.setOnRefreshListener(this)
        main_refresh.setColorSchemeColors(ContextCompat.getColor(context!!, R.color.pink_accent_color),
                ContextCompat.getColor(context!!, R.color.colorPrimary),
                ContextCompat.getColor(context!!, R.color.green_accent_color),
                ContextCompat.getColor(context!!, R.color.yellow_accent_color),
                ContextCompat.getColor(context!!, R.color.cyan_accent_color))*/
        list.setHasFixedSize(true)
        //list.adapter = GameAdapter(requireContext()) { controller.onClick(it) }
        //list.adapter as

    }

    protected open fun prepareDrawables() {
        noContentIcon.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.ic_controller))
        noContentMessage.setText(R.string.no_games)
    }

    fun showContent(state: Boolean) {
        noContent.visibility = if (state) View.GONE else View.VISIBLE
        list.visibility = if (state) View.VISIBLE else View.GONE
    }

    private fun prepareView(inflater: LayoutInflater?, container: ViewGroup?): View {
        return inflater!!.inflate(R.layout.games_list_view, container, false)
    }

    private fun loadGames() {
        //controller.loadGames(iLibrary)
    }

    override fun onRefresh() {
       // controller.onRefresh(iLibrary)
    }


    fun swapContent(items: List<Game>) {
        showContent(items.isNotEmpty())
        //adapter.swap(items)
    }

    fun stopRefreshing() {
        refreshLayout.isRefreshing = false
    }


    fun handleItemClick(game: Game) {
        val sheet = GameInformationView.show(game)
        sheet.show(fragmentManager, TAG + "_SHEET")
    }


    companion object {
        private const val TAG = "BaseFragment"
    }
}

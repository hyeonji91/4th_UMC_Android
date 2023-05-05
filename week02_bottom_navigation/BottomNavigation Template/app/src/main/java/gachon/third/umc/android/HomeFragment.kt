package gachon.third.umc.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import gachon.third.umc.android.databinding.FragmentHomeBinding
import android.graphics.Rect
import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import gachon.third.umc.android.databinding.ItemPostBinding

class HomeFragment: Fragment() {

    //private lateinit var storyAdapter: StoryAdapter
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storyData = ArrayList<StoryData>()
        val storyAdapter = StoryAdapter(storyData)
        binding.storyRecyclerview.adapter = storyAdapter
        binding.storyRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        addStroy(storyData)
        binding.storyRecyclerview.adapter?.notifyDataSetChanged()
        binding.storyRecyclerview.addItemDecoration(RecyclerViewDecoration(32));





        val postData = ArrayList<PostData>()
        val postAdapter = PostAdapter(postData)
        val postRecyclerView: RecyclerView = binding.postRecyclerview
        postRecyclerView.adapter = postAdapter
        postRecyclerView.layoutManager = LinearLayoutManager(activity)

        addPost(postData)

    }

}


class RecyclerViewDecoration(private val divWidth: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = divWidth
    }
}

fun addStroy(storyData : ArrayList<StoryData>){
    storyData.add(StoryData("user1 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user2 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user3 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user4 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user5 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user6 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user7 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user8 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
    storyData.add(StoryData("user9 ", R.drawable.ic_profile_default, R.drawable.ic_story_border))
}

fun addPost(postData: ArrayList<PostData>){
    postData.add(PostData(
        R.drawable.ic_profile_default,
        "user1",
        R.drawable.ic_launcher_background,
        SpannableString("좋아요 1개\n"+"user1 "+" 안녕하세요 가천대학교 UMC 초코입니다\n"+"댓글 10개 모두보기\n"+"5월5일")
    ))
    postData.add(PostData(
        R.drawable.ic_profile_default,
        "user2",
        R.drawable.ic_launcher_background,
        SpannableString("좋아요 1개\n"+"user2 "+" 안녕하세요 가천대학교 UMC 초코입니다\n"+"댓글 10개 모두보기\n"+"5월5일")
    ))
    postData.add(PostData(
        R.drawable.ic_profile_default,
        "user3",
        R.drawable.ic_launcher_background,
        SpannableString("좋아요 1개\n"+"user3 "+" 안녕하세요 가천대학교 UMC 초코입니다\n"+"댓글 10개 모두보기\n"+"5월5일")
    ))
}

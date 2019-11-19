package org.abodah.petit.cclean.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.abodah.petit.cclean.data.model.api.BlogResponse;

import java.util.List;

public final class BindingUtils {
    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, List<BlogResponse.Blog> blogs) {
        BlogAdapter adapter = (BlogAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(blogs);
        }
    }

//    @BindingAdapter({"adapter"})
//    public static void addOpenSourceItems(RecyclerView recyclerView, List<OpenSourceItemViewModel> openSourceItems) {
//        OpenSourceAdapter adapter = (OpenSourceAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.clearItems();
//            adapter.addItems(openSourceItems);
//        }
//    }
//
//    @BindingAdapter({"adapter", "action"})
//    public static void addQuestionItems(SwipePlaceHolderView mCardsContainerView, List<QuestionCardData> mQuestionList, int mAction) {
//        if (mAction == MainViewModel.ACTION_ADD_ALL) {
//            if (mQuestionList != null) {
//                mCardsContainerView.removeAllViews();
//                for (QuestionCardData question : mQuestionList) {
//                    if (question != null && question.options != null && question.options.size() == 3) {
//                        mCardsContainerView.addView(new QuestionCard(question));
//                    }
//                }
//                ViewAnimationUtils.scaleAnimateView(mCardsContainerView);
//            }
//        }
//    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

}

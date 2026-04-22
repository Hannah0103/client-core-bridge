package com.example.hannah_android_demo.ui.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.hannah_android_demo.R;

public class SubtabFragment extends Fragment {
    private static final String ARG_TITLE = "arg_title";
    private static final String ARG_CONTENT = "arg_content";

    public static SubtabFragment newInstance(String title, String content) {
        SubtabFragment fragment = new SubtabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subtab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.tv_subtab_title);
        Bundle args = getArguments();
        if (args != null) {
            String content = args.getString(ARG_CONTENT, "");
            if (content == null || content.isEmpty()) {
                content = args.getString(ARG_TITLE, "");
            }
            textView.setText(content);
        }
    }
}

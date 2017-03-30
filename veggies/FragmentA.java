package bg.ittalents.veggies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    private TextView textView;
    private static int cnt = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_a, container, false);
        textView = (TextView) root.findViewById(R.id.fragment_tv);
        textView.setText("I`m fragment " + (cnt++));
        return root;
    }

}

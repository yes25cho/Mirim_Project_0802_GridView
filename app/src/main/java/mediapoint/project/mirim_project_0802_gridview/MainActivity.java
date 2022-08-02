package mediapoint.project.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId ={R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img08,R.drawable.img09,R.drawable.img10,
            R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img08,R.drawable.img09,R.drawable.img10,
            R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img08,R.drawable.img09,R.drawable.img10};
    String[] posterName = {"호텔델루나", "뷰티인사이드", "도깨비", "맬로가체질",
            "사랑의 불시착", "사이코지만 괜찮아", "스물다섯스물하나",
            "슬기로운 의사생활", "유미의 세포들", "이상한 변호사 우영우","호텔델루나", "뷰티인사이드", "도깨비", "맬로가체질",
            "사랑의 불시착", "사이코지만 괜찮아", "스물다섯스물하나",
            "슬기로운 의사생활", "유미의 세포들", "이상한 변호사 우영우","호텔델루나", "뷰티인사이드", "도깨비", "맬로가체질",
            "사랑의 불시착", "사이코지만 괜찮아", "스물다섯스물하나",
            "슬기로운 의사생활", "유미의 세포들", "이상한 변호사 우영우"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신 영화 포스터 (네이버시리즈온)");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);

    }

    public class PosterAdapter extends BaseAdapter{
        Context context;
        public PosterAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(200,300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);
            final  int pos = i;
             imgv.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                     dlg.setTitle(posterName[pos]);
                     dlg.setIcon(R.drawable.icon);
                     View dlgView = View.inflate(MainActivity.this, R.layout.dialog,null);
                     ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                     imgvDlg.setImageResource(posterId[pos]);
                     dlg.setView(dlgView);
                     dlg.setNegativeButton("닫기", null);
                     dlg.show();
                 }
             });
            return imgv;
        }
    }
}
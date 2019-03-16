package com.example.searchlist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

         // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<ListVO> list;
    private ArrayList<ListVO> arraylist;
    int []img={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<ListVO>();
        arraylist = new ArrayList<ListVO>();
        String aaa[]=new String[]{};

        ListVO asd;
        ListVO asd1;
        ListVO asd2;

        asd = new ListVO();
        asd.setImg(ContextCompat.getDrawable(this,img[0]));
        asd.setTitle("안녕");
        asd.setContext("안녕라세요");

        asd1 = new ListVO();
        asd1.setImg(ContextCompat.getDrawable(this,img[1]));
        asd1.setTitle("안녕");
        asd1.setContext("안녕라세요");

        asd2 = new ListVO();
        asd2.setImg(ContextCompat.getDrawable(this,img[2]));
        asd2.setTitle("안녕");
        asd2.setContext("안녕라세요");

        list.add(asd);
        list.add(asd1);
        list.add(asd2);

        // 검색에 사용할 데이터을 미리 저장한다.
        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list,this);
        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);
        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });



    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getTitle().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                  ListVO listVO = new ListVO();
                  listVO.setImg(arraylist.get(i).getImg());
                  listVO.setTitle(arraylist.get(i).getTitle());
                  listVO.setContext(arraylist.get(i).getContext());
                  list.add(listVO);
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.

}
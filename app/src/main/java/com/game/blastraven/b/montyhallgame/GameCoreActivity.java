package com.game.blastraven.b.montyhallgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class GameCoreActivity extends AppCompatActivity {
    Database database= new Database();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_core);
        TextView game_core = this.findViewById(R.id.textView);
        String game_core_view = getString(R.string.game_core);
        String datacatch=database.reading();
        //ボタンを非表示にする
        BootstrapButton button1 = this.findViewById(R.id.bootstrapDoor1);
        button1.setVisibility(View.INVISIBLE);

    }
    //public void writeing(View view) {game_core.setText(Database.reading());}
    public void writeing(View view) {
        database.writeing();
    }
    public void reading(View view) {
        database.reading();
    }
}


class Game  {
    int select;//プレイヤーが選んだドア
    int firstId;//プレイヤーが最初に選んだドアのidを保存しておく変数
    int finalId;//プレイヤーが最終的にに選んだドアのidを保存しておく変数
    int level;//現在のステージ
    String stage;//現在の段階
    int dummy;//プレイヤーが1回目で正解のドアを選んだ際に指定される不正解のドア
    int score = 0;//現在のプレイヤーのスキル
    //1回目のドア選択(一旦切り離し!)

    void FirstChoice() {
        int firstId;

    }

    //最後のドア選択
    void FinalChoice() {

    }

}

class Door {
    final int id;//ドアの固有ID
    boolean choose = false;//プレイヤーはこのドアを選んだか?
    boolean open = false;//結局ドアは今空いているのか?
    boolean correct = false;//これは正解のドアか?

    Door(int id) {
        this.id = id;
    }
}
/*
 public void writeing(View view) {
        writeFile("testing!!");
    }
    public void reading(View view) {
        //readFile(getFilesDir());
    }

    //ファイルの書き込みクラス
    private void writeFile(String contents){
        //ファイルを出力するフォルダの作成
        File temppath=new File(Environment.getExternalStorageDirectory().getPath() + "/"+"TESTFILE");
        //File temppath=new File(getFilesDir(), "TESTFILE");
        if (temppath.exists() != true){
            temppath.mkdirs();
            Toast.makeText(this, "cleate", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Oready", Toast.LENGTH_LONG).show();
        }
        //ファイルをオープン
        File tempfile =new File(temppath,"TEST.txt");
        FileWriter output =null;
        try{
            output =new FileWriter(tempfile,true);
            //書き込む!!
            output.write(contents);
            output.write("\n");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(output !=null){
                try{
                    output.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //ファイルの読み込みクラス
    private void readFile(){
        try{
            //Uriからファイルのパスを取得してFileを作成する
            File file =new File(Environment.getExternalStorageDirectory().getPath() + "/"+"TESTFILE");
            mTextFilename.setText(file.getName());
            //FileからReaderクラスを作成
            BufferedReader bufferReader=new BufferedReader(new FileReader(file));
            String StringBuffer;
            String stringText="";
            //一行ずつ読み込みString形式のデータを作成
            while ((StringBuffer=bufferReader.readLine()) != null){
                stringText+=StringBuffer;
            }
            bufferReader.close();
            mTextContents.setText(stringText);
        }catch (MalformedURLException e){
            e.printStackTrace();
            mTextContents.setText(e.toString());
        }
        catch (IOException e){
            e.printStackTrace();
            mTextContents.setText(e.toString());
        }
    }
 */
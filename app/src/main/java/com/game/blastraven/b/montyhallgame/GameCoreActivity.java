package com.game.blastraven.b.montyhallgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class GameCoreActivity extends AppCompatActivity {
    //インターフェイスの実装と処理の記述
    Subcode subcode = new Subcode() {
        //interface Subcodeのオーバーライド
        @Override
        public void disableButton() {
            BootstrapButton button1 = findViewById(R.id.bootstrapDoor1);
            button1.setVisibility(View.INVISIBLE);
        }

        //interface Subcodeのオーバーライド
        @Override
        public int idSearch() {
            int id = 0;
            for (int i = 0; i < 99; i++) {
                if (door[i].choose == true) {
                    id = door[i].id;
                }
            }
            return id;
        }

        @Override
        public void writeing(String finalscore) {
            database.writeing(finalscore);
        }

        @Override
        public void reading() {
            database.reading();
        }

        @Override
        public void textChange(String name, String input, String output) {
            //TextView name = findViewById(R.id.output);
            //name.setText(R.string.input);
        }
    };
    Database database;
    Game game = new Game(subcode);
    Door[] door = new Door[100];
    //画面テキストを変更するためにテキストビューを指定
    TextView game_core;
    //bootstrapのドアをプログラムから制御するために名前付け
    static BootstrapButton DoorButton1;
    static BootstrapButton DoorButton2;
    static BootstrapButton DoorButton3;
    static BootstrapButton DoorButton4;
    static BootstrapButton DoorButton5;
    static BootstrapButton DoorButton6;
    static BootstrapButton DoorButton7;
    static BootstrapButton DoorButton8;
    static BootstrapButton DoorButton9;
    static BootstrapButton DoorButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = new Database(this);
        for (int i = 0; i < 99; i++) {
            door[i] = new Door(i + 1, subcode);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_core);
        //bootstrapのドアをプログラムから制御するために名前付け(続き)
        DoorButton1 = findViewById(R.id.bootstrapDoor1);
        DoorButton2 = findViewById(R.id.bootstrapDoor2);
        DoorButton3 = findViewById(R.id.bootstrapDoor3);
        DoorButton4 = findViewById(R.id.bootstrapDoor4);
        DoorButton5 = findViewById(R.id.bootstrapDoor5);
        DoorButton6 = findViewById(R.id.bootstrapDoor6);
        DoorButton7 = findViewById(R.id.bootstrapDoor7);
        DoorButton8 = findViewById(R.id.bootstrapDoor8);
        DoorButton9 = findViewById(R.id.bootstrapDoor9);
        DoorButton10 = findViewById(R.id.bootstrapDoor10);
        game_core = this.findViewById(R.id.textView);
        String game_core_view = getString(R.string.game_core, game.select);
        game_core.setText(game_core_view);
        if (game.stage == null) {
            game.stage = "outofrange";
        }
        switch (game.stage) {
            case "start":
                game.GameStart();
                break;
            case "firstchoice":
                game.FirstChoice();
                break;
            case "finalchoice":
                game.FinalChoice();
                break;
            case "StageClear":
                game.StageClear();
                break;
            case "GameOver":
                game.GameOver();
                break;
            case "GameSet":
                game.GameSet();
                break;
        }

    }

    //public void writeing(View view) {game_core.setText(Database.reading());}

    void screenUpdate() {
        String game_core_setview = getString(R.string.game_core, game.select);
        game_core.setText(game_core_setview);
    }


    //各ボタンを押したときの動作
    //ドアボタン
    public void buttonclick(View view) {
        //共通の処理
        for (int i = 0; i < 99; i++) {
            door[i].choose = false;
        }
        //押されたボタンごとに個別の動作
        switch (view.getId()) {

            case R.id.bootstrapDoor1:
                door[0].choose = true;
                DoorButton1.setShowOutline(true);
                //DoorButton1.setButtonMode();
                break;
            case R.id.bootstrapDoor2:
                door[1].choose = true;
                DoorButton2.setShowOutline(true);
                break;
            case R.id.bootstrapDoor3:
                door[2].choose = true;
                DoorButton3.setShowOutline(true);
                break;
            case R.id.bootstrapDoor4:
                door[3].choose = true;
                DoorButton4.setShowOutline(true);
                break;
            case R.id.bootstrapDoor5:
                door[4].choose = true;
                DoorButton5.setShowOutline(true);
                break;
            case R.id.bootstrapDoor6:
                door[5].choose = true;
                DoorButton6.setShowOutline(true);
                break;
            case R.id.bootstrapDoor7:
                door[6].choose = true;
                DoorButton7.setShowOutline(true);
                break;
            case R.id.bootstrapDoor8:
                door[7].choose = true;
                DoorButton8.setShowOutline(true);
                break;
            case R.id.bootstrapDoor9:
                door[8].choose = true;
                DoorButton9.setShowOutline(true);
                break;
            case R.id.bootstrapDoor10:
                door[9].choose = true;
                DoorButton10.setShowOutline(true);
                break;
        }
        //共通の処理
        game.select = subcode.idSearch();
        screenUpdate();

        /*ボタン旧案
    public void bootstrapDoor1(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[0].choose=true;

    }
    public void bootstrapDoor2(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[1].choose=true;
    }
    public void bootstrapDoor3(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[2].choose=true;
    }
    public void bootstrapDoor4(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[3].choose=true;
    }
    public void bootstrapDoor5(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[4].choose=true;
    }
    public void bootstrapDoor6(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[5].choose=true;
    }
    public void bootstrapDoor7(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[6].choose=true;
    }
    public void bootstrapDoor8(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[7].choose=true;
    }
    public void bootstrapDoor9(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[8].choose=true;
    }
    public void bootstrapDoor10(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[9].choose=true;
    }
    */
    }

    //書き込み/読み込みボタン(テスト用)
    public void database(View view) {
        switch (view.getId()) {
            case R.id.writeing:
                database.writeing("Dummy");
                break;
            case R.id.reading:
                //database.reading();
                Toast.makeText(this, database.reading(), Toast.LENGTH_LONG).show();
                break;
        }
    }
    //ボタンの色をもとに戻す
    void buttonColorReset(){
        DoorButton1.setShowOutline(false);
        DoorButton2.setShowOutline(false);
        DoorButton3.setShowOutline(false);
        DoorButton4.setShowOutline(false);
        DoorButton5.setShowOutline(false);
        DoorButton6.setShowOutline(false);
        DoorButton7.setShowOutline(false);
        DoorButton8.setShowOutline(false);
        DoorButton9.setShowOutline(false);
        DoorButton10.setShowOutline(false);
    }
}

//処理の移譲
interface Subcode {
    //ボタンを非表示にする(テスト用)
    void disableButton();

    //プレイヤーに選択されているドアのidを返す関数
    int idSearch();

    void writeing(String score);

    void reading();

    void textChange(String name, String input, String output);
}
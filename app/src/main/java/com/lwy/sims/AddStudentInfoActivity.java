package com.lwy.sims;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.lwy.sims.dao.AddStudentInfoDao;
import com.lwy.sims.entity.StudentInfo;

public class AddStudentInfoActivity extends Activity {
	//???????
	EditText editnum,editname,editage,editmark;
	RadioButton radiomen,radiowomen;
	ArrayAdapter<String> proadapter;
	String[] proname={"????????","?????????","???????????","WEB??????"};
	Spinner pro;
	Button butok,butre;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_student_info);
		//????init()????
        this.init();
      //??????????????
        this.butok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View V) {
				//???????????????
				addaction();
			}
		});
        //???????????????
        this.butre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				qingkongaction();
			}
		});
	}
	//?????????????????
	public void init(){
    	this.editnum=(EditText) findViewById(R.id.addnumedit);
    	this.editname=(EditText) findViewById(R.id.addnameedit);
    	this.radiomen=(RadioButton) findViewById(R.id.addradioman);
    	this.radiowomen=(RadioButton) findViewById(R.id.addradiowoman);
    	this.editage=(EditText) findViewById(R.id.addageedit);
    	this.pro=(Spinner) findViewById(R.id.spinner1);
    	//??????????--?????--??????
    	this.proadapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,this.proname);
    	//????spinpro ?????
    	this.pro.setAdapter(proadapter);
    	this.editmark=(EditText) findViewById(R.id.addmarkedit);
    	this.butok=(Button) findViewById(R.id.addbutton);
    	this.butre=(Button) findViewById(R.id.resbutton);
    	
    }
	//??????????????
       public void addaction(){
    			//1.??????????????
    			String num=this.editnum.getText().toString();
//    			//nn????§Ø?
//    			double nn=Integer.parseInt(num);
    			String name=this.editname.getText().toString();
    			String sex="??";
        		if(this.radiowomen.isChecked()){
        			//
        			sex="?";
        		}
        		String age=this.editage.getText().toString();
        		String pro=this.pro.getSelectedItem().toString();
    			String mark=this.editmark.getText().toString();
    			//2.??????? ?›¥?????????
    			StudentInfo tem=new StudentInfo();
    			tem.setNum(num);
    			tem.setName(name);
    			tem.setSex(sex);
    			tem.setAge(age);
    			tem.setPro(pro);
    			tem.setMark(mark);
    			AddStudentInfoDao adao=new AddStudentInfoDao(this);
    			long n=adao.addStudentInfo(tem);
    			//3.?????????
    			String mes="????????????";
    			if(n>0){
    				mes="???????????";
    			}
    			Toast.makeText(this, mes, Toast.LENGTH_LONG).show();
    	}
       //??????????????
       public void qingkongaction(){
    	   this.editnum.setText("");
    	   this.editname.setText("");
    	   //????????????§ß?????????
    	   this.radiomen.setChecked(true);
    	   this.editage.setText("");
    	   //?????????????????????????
    	   this.pro.setSelection(0);
    	   this.editmark.setText("");
       }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

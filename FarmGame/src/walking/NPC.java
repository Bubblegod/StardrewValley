package walking;

import java.util.Random;


public class NPC extends Thread implements gameConfig {
	int start=13;
	int end=13;
	int count=0;
	int colum=59;
	int pastImg=0;
	public void run() {
		init();
		while(true){
			Move();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void init() {
		
		for(int i=0;i<100;i++){
			for(int j=0;j<3;j++){
				ReadMapFile.map1[i][j]=4;//initialize the sea in the map
			}
		}
		
		for(int i=0;i<70;i++){
			for(int j=0;j<70;j++){
				ReadMapFile.map2[i][j]=0;//initialize the map
			}
		}
		
		
		ReadMapFile.map2[10][10]=200;
		
		for(int i=7;i<10;i++){
			for(int j=25;j<33;j++){
				ReadMapFile.map2[i][j]=999;//invalid area
		}
		}ReadMapFile.map2[7][25]=105;//house
		
		for(int i=7;i<10;i++){
			for(int j=15;j<18;j++){
				ReadMapFile.map2[i][j]=999;//invalid area
		}
		}ReadMapFile.map2[7][15]=107;//barn
		
		for(int i=7;i<10;i++){
			for(int j=38;j<46;j++){
				ReadMapFile.map2[i][j]=999;//invalid area
		}
		}ReadMapFile.map2[7][38]=108;//slime
		
		ReadMapFile.map2[10][59]=106;//volcano
		
		for(int i=4;i<7;i++){
			for(int j=3;j<100;j++){
				ReadMapFile.map2[i][j]=103;//tree
			}
		}
		for(int i=7;i<100;i++){
			for(int j=3;j<7;j++){
				ReadMapFile.map2[i][j]=103;//tree
			}
		}
		for(int i=7;i<100;i++){
			for(int j=55;j<57;j++){
				ReadMapFile.map2[i][j]=101;//tree
			}
		}
		
		
		int grassamount=0;
		Random rand =new Random();
		while(grassamount<100){
			int randi,randj;
			randi=rand.nextInt(16);
			randi+=13;
			randj=rand.nextInt(40);
			randj+=7;
			if(ReadMapFile.map2[randi][randj]==0){
				ReadMapFile.map2[randi][randj]=200;
				grassamount++;
			}
			
		}
		
	}
	public void Move () {
		
		if(count<4){
		if(start-1>0)start-=1;
		end+=1;
		colum-=1;
		for(int i=start;i<=end;i++){
			ReadMapFile.map2[i][colum]=150;
			
		}
		count++;
		}
	}

}

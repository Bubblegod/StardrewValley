package walking;

import javax.swing.ImageIcon;
/**
 * ��Ϸ���ͨ����ȡ�����е�int��ƥ�䵽��Ӧ��Ԫ��ͼƬ������
 * 
 *
 */
public class GetMap implements gameConfig{
	//ͨ������ƥ��ͼƬ
		static ImageIcon int2icon(int num){
			if(num==0){
				return icon0;
			}else if(num==1){
				return icon1;
			}else if(num==2){
				return icon2;
			}else if(num==3){
				return icon3;
			}else if(num==4){
				return icon4;
			}else if(num==5){
				return icon5;
			}else if(num==101){
				return icon101;
			}else if(num==102){
				return icon102;
			}else if(num==103){
				return icon103;
			}else if(num==105){
				return icon105;
			}else if(num==106){
				return icon106;
			}else if(num==107){
				return icon107;
			}else if(num==108){
				return icon108;
			}else if(num==150){
				return icon150;
			}else if(num==200){
				return icon200;
			}else if(num==999){
				return icon999;
			}
			return null;
		}
}

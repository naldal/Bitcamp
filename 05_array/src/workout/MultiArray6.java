package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiArray6 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name, subject ="";
		int cnt, subjectCnt, jumsu, sum=0;
		double avg=0.0;
		
		System.out.print("�ο���: ");
			cnt=Integer.parseInt(br.readLine());
			String[][] ar = new String[cnt*2][];
			
			for(int i=0; i<ar.length; i+=2) {
				System.out.print("�̸��Է�: ");
				name = br.readLine();
				
				System.out.print("����� �Է�: ");
				subjectCnt = Integer.parseInt(br.readLine());
				ar[i] = new String[subjectCnt+3];
				ar[i+1] = new String[subjectCnt+3];
				
				ar[i][0]="�̸�";
				ar[i+1][0] = name;
				
				for(int j=0; j<subjectCnt; j++) {
					System.out.print("����� �Է�: ");
					subject = br.readLine();
					ar[i][j+1] = subject;
					
					ar[i][subjectCnt+1] = "����";
					ar[i][subjectCnt+2] = "���";
				} // for j
				
				for(int k=0; k<subjectCnt; k++) {
					System.out.print(ar[i][k+1]+" ���� �Է� : ");
					jumsu = Integer.parseInt(br.readLine());
					ar[i+1][k+1] = jumsu+"";
					
					sum+=jumsu;
						
				}
				
				ar[i+1][subjectCnt+1]=sum+"";
				
				avg = (double)sum/subjectCnt;
				sum=0;
				ar[i+1][subjectCnt+2] = String.format("%.2f",avg);
				
			}//for i
			
			for(int i=0; i<ar.length; i++) {
				for(int j=0; j<ar[i].length; j++) {
					System.out.print(ar[i][j]+"\t");
				}
				System.out.println();
			}
			
		}	
	} 



/*
 �ο����� �Է��Ͽ� �ο�����ŭ �����͸� �Է¹ް� ������ ����� ���Ͻÿ�
 ����� �Ҽ����� 2°�ڸ����� ��� (�������� �迭 ���)
 
 [������]
 �ο���:2 (cnt)
 
 �̸��Է�: ȫ�浿(name)
 ������Է�:2 (subjectCnt)
 ������Է�:����  (subject) 
 ����� �Է�:����
 ���� ���� �Է�:95 (jumsu)
 ���� ���� �Է�:100
------------------------
 �̸��Է�: �̱���(name)
 ������Է�:3 (subjectCnt)
 ������Է�:����  (subject) 
 ����� �Է�: ����
 ����� �Է�: ����
 ���� ���� �Է�:95 (jumsu)
 ���� ���� �Է�:100
 
... 
 -----------------
  �̸�  ����  ����   ����     ���
 ȫ�浿 95 100 xxx xx.xx
 
  �̸�   ���� ����  ����   ����   ���
 �̱��� 95 100 90 xxx xx.xx
 */

package constructor;

public class VarArgs {	//variable argument

	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		System.out.println("��="+va.sum(10,20));	//ȣ��
		System.out.println("��="+va.sum(10,20,30));	//ȣ��
		System.out.println("��="+va.sum(10,20,30,40));	//ȣ��
	}
	
	public int sum(int... ar) {
		int tot=0;
		for(int i=0; i<ar.length; i++) {
			tot+=ar[i];
		}
		return tot;
	}

//	private int sum(int i, int j) {
//		// TODO Auto-generated method stub
//		return i+j;
//	}
//
//	private int sum(int i, int j, int k) {
//		// TODO Auto-generated method stub
//		return i+j+k;
//	}
//	
//	private int sum(int i, int j, int k, int l) {
//		// TODO Auto-generated method stub
//		return i+j+k+l;
//	}
}

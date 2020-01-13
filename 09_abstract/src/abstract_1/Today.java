package abstract_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y�� MM�� dd�� E���� H:m:ss");
		System.out.println("���� ��¥:" + simpleDateFormat.format(date));

		// 1991 07 16
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716103515"); // String -> date���� ��ȯ
		System.out.println("�� ���� : " + birth);
		System.out.println("�� ����  : " + simpleDateFormat.format(birth));

		// Calendar cal = new Calendar(); �߻�Ŭ�����̹Ƿ� �������� �Ұ�
		// Calendar cal = new GregorianCalendar(); //sub class �̿��� ����

		Calendar cal2 = Calendar.getInstance();
		int year = cal2.get(Calendar.YEAR); // api�󿡼��� 1�� year
		int month = cal2.get(Calendar.MONTH) + 1; // 1�� - 0
		int day = cal2.get(Calendar.DAY_OF_MONTH);
		int week = cal2.get(Calendar.DAY_OF_WEEK); // �Ͽ��� - 1

		String dayOfWeek = null;
		switch (week) {
		case 1:
			dayOfWeek = "�Ͽ���";
			break;
		case 2:
			dayOfWeek = "������";
			break;
		case 3:
			dayOfWeek = "ȭ����";
			break;
		case 4:
			dayOfWeek = "������";
			break;
		case 5:
			dayOfWeek = "�����";
			break;
		case 6:
			dayOfWeek = "�ݿ���";
			break;
		case 7:
			dayOfWeek = "�����";
			break;
		}

		System.out.println(year + "�� " + month + "�� " + day + "�� " + dayOfWeek);
	}

}

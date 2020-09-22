package org.iit.mmp.patientmodule.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class leraningEnum {
//	static String day = "09/10/2020";
//	
//	enum Month{
//		January(1),FEBRURAY(2),MARCH(3),APRIL(4),MAY(5),JUNE(6),JULY(7),AUGUST(8),SEPTEMBER(9),OCTOBER(10),NOVEMBER(11),DECEMBER(12);
//		int num ;
//		private Month(int num){
//			this.num = num;
//		}
//		;
//		public int getNumber() {
//			return num;			
//		}
//	}
//	
	public static void main(String args[]) {
		//System.getProperty("user.dir") will give you path of project.
	String filePath = System.getProperty("user.dir")+"//src//text//resource//MMPTextVerificationFile.txt";
	
System.out.println(filePath);
		
		
		
	}
		
//		FileReader fr = null;
//        BufferedReader br = null;
//        String str = "";
//        String txt ="";
//
//			
//			try {
//				
//				File file = new File("MMPTextVerificationFile.txt");
//
//				fr = new FileReader(file.getAbsolutePath());
//				br = new BufferedReader(fr);
//
//				while ((str = br.readLine()) != null) {
//					txt = txt+str;
//					
//
//				}
//				System.out.println(txt);
//				
//
//			} catch (IOException e) {
//				e.printStackTrace();
//
//			} finally {
//
//				try {
//					fr.close();
//					br.close();
//				} catch (IOException e) {
//
//					e.printStackTrace();
//				}
//
//			}
//			
//
//		}
	//}
//		Date date = new Date("December/25/2020");
//		//Date date = new Date("December 25, 2020");
//		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMMM");
//		SimpleDateFormat monthIntFormat = new SimpleDateFormat("MM");
//		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
//		SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
////		System.out.println(monthFormat.format(date));
////		System.out.println(monthIntFormat.format(date));
////		System.out.println(dayFormat.format(date));
////		System.out.println(yearFormat.format(date));
//		System.out.println(monthIntFormat.format(date)+"/"+dayFormat.format(date)+"/"+yearFormat.format(date));
//
//	}
}


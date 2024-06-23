package com.opencv.algorithm;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Scalar;
import org.opencv.features2d.DMatch;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.Features2d;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import com.dao.AdminDAO;

public class RANSCAR 
{
	public int homography(String imgsrc,String imgcmp,String fwritepath)
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String firstImageSourcePath = imgsrc;
	    String secondImageSourcePath = imgcmp;
	    //String secondImageSourcePath = "images.jpg";

	    int count=0;
	    int count2=0;
	    
	   Mat img1 = Highgui.imread(firstImageSourcePath);
	    
	   // Mat img1= Highgui.imread(firstImageSourcePath, Highgui.CV_LOAD_IMAGE_GRAYSCALE);
	   Mat img2 = Highgui.imread(secondImageSourcePath);
	   
	  // Mat img2 = Highgui.imread(secondImageSourcePath, Highgui.CV_LOAD_IMAGE_GRAYSCALE);
		
	   FeatureDetector detector = FeatureDetector.create(FeatureDetector.ORB);
	    DescriptorExtractor descriptor = DescriptorExtractor.create(DescriptorExtractor.ORB);
	    DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_HAMMING);
	    // First photo
	    Imgproc.cvtColor(img1, img1, Imgproc.COLOR_RGB2GRAY);
	    Mat descriptors1 = new Mat();
	    MatOfKeyPoint keypoints1 = new MatOfKeyPoint();

	    detector.detect(img1, keypoints1);
	    descriptor.compute(img1, keypoints1, descriptors1);

	    // Second photo
	    Imgproc.cvtColor(img2, img2, Imgproc.COLOR_RGB2GRAY);
	    Mat descriptors2 = new Mat();
	    MatOfKeyPoint keypoints2 = new MatOfKeyPoint();

	    detector.detect(img2, keypoints2);
	    descriptor.compute(img2, keypoints2, descriptors2);

	    // Matching

	    MatOfDMatch matches = new MatOfDMatch();
	    MatOfDMatch filteredMatches = new MatOfDMatch();
	    matcher.match(descriptors1, descriptors2, matches);

	    // Linking
	    Scalar RED = new Scalar(0);
	    Scalar GREEN = new Scalar(100);

	    List<DMatch> matchesList = matches.toList();
	    Double max_dist = 0.0;
	    Double min_dist = 30.0;

	   /* for(int i = 0;i < matchesList.size(); i++){
	        Double dist = (double) matchesList.get(i).distance;
	        
	        System.out.println("=====================dist============");
	        System.out.println("dist :"+dist);
	        System.out.println("=====================================");
	        
	        if (dist < min_dist)
	        {
	        	System.out.println("less than min");
	        	  min_dist = dist;
	        }	            
	        else if ( dist > max_dist)
	        {
	        	System.out.println("max ");
	        	max_dist = dist;
	        }
	            
	    }*/


	    

	    LinkedList<DMatch> good_matches = new LinkedList<DMatch>();
	    for(int i = 0;i < matchesList.size(); i++){
	    	count2=count2+1;
	    	// if (matchesList.get(i).distance <= (1.5 * min_dist))
	        if (matchesList.get(i).distance <= (min_dist))
	        {
	        	System.out.println("match :"+matchesList.get(i));
	        	count=count+1;
	            good_matches.addLast(matchesList.get(i));
	        }
	    }



	    // Printing
	    MatOfDMatch goodMatches = new MatOfDMatch();
	    goodMatches.fromList(good_matches);
	    
	   
	    System.out.println("=========================================++++++++++++++++++++++++++");
	    System.out.println(matches.size() + " " + goodMatches.size());
	    int goodMatchFound = good_matches.size();
	    
	    double percentage =  (goodMatchFound*100)/count2;
	   
	   System.out.println("match percentage is: "+percentage+"%");

	    System.out.println("total matches :"+count);
	    System.out.println("=========================================");
	    
	    int id = 1;
	    
	    boolean flag2 = AdminDAO.updateMatchPercentage(id,percentage);
	    System.out.println("updateMatchPercentage "+flag2);
	    
	    Mat outputImg = new Mat();
	    MatOfByte drawnMatches = new MatOfByte();
	    Features2d.drawMatches(img1, keypoints1, img2, keypoints2, goodMatches, outputImg, GREEN, RED, drawnMatches, Features2d.NOT_DRAW_SINGLE_POINTS);

	   // String filename = "/home/username/Output.png";
	    
	    Highgui.imwrite(fwritepath, outputImg);
	    
	   // BufferedImage gray = new BufferedImage(outputImg.width(), outputImg.height(), BufferedImage.TYPE_BYTE_GRAY);
		return count;
	}
	
	public static void main(String[] args) {
		
	}

}

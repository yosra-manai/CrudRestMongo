/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restMongo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdallah
 */
@XmlRootElement(name = "Movies") 
public class Movies {

 
 private String title; 
 private Integer year; 
 private String genre;  
 private String summary; 
 private String country; 

   
  
 public void setTitle(String String){
  this.title = String;
 }
  public void setYear(Integer String){
  this.year = String;
 }
 public void setGenre(String String){
  this.genre = String;
 }
  
 public void setSummary(String String){
  this.summary = String;
 }
 public void setCountry(String String){
  this.country = String;
 }
  
 @XmlElement 
 public String getTitle(){
  return this.title ;
 }
 @XmlElement 
 public Integer getYear(){
  return this.year;
 }
 @XmlElement 
 public String getGenre(){
  return this.genre;
 }
 @XmlElement 
 public String getSummary(){
  return this.summary;
 }
 @XmlElement 
 public String getCountry(){
  return this.country ;
 }
 
}

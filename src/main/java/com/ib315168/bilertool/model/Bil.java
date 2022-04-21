package com.ib315168.bilertool.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Bil
{
  private String numberPlates;
  private String make;
  private String model;
  private String bodyType;
  private int km;
  private Date yor;
  private double kmpl;
  private String drive;
  private int weight;
  private String engineType;
  private int volume;
  private int cyl;
  private int hp;
  private boolean gearbox;
  private boolean hybrid;

  public Bil(String numberPlates, String make, String model, String bodyType,
      int km, Date yor, double kmpl, String drive, int weight,
      String engineType, int volume, int cyl, int hp, boolean gearbox,
      boolean hybrid)
  {
    this.numberPlates = numberPlates;
    this.make = make;
    this.model = model;
    this.bodyType = bodyType;
    this.km = km;
    this.yor = yor;
    this.kmpl = kmpl;
    this.drive = drive;
    this.weight = weight;
    this.engineType = engineType;
    this.volume = volume;
    this.cyl = cyl;
    this.hp = hp;
    this.gearbox = gearbox;
    this.hybrid = hybrid;
  }

  public String getNumberPlates()
  {
    return numberPlates;
  }

  public String getMake()
  {
    return make;
  }

  public String getModel()
  {
    return model;
  }

  public String getBodyType()
  {
    return bodyType;
  }

  public int getKm()
  {
    return km;
  }

  public Date getYor()
  {
    return yor;
  }

  public double getKmpl()
  {
    return kmpl;
  }

  public String getDrive()
  {
    return drive;
  }

  public int getWeight()
  {
    return weight;
  }

  public String getEngineType()
  {
    return engineType;
  }

  public int getVolume()
  {
    return volume;
  }

  public int getCyl()
  {
    return cyl;
  }

  public int getHp()
  {
    return hp;
  }

  public boolean isGearbox()
  {
    return gearbox;
  }

  public boolean isHybrid()
  {
    return hybrid;
  }

  @Override public String toString()
  {
    return numberPlates + " - " + yor.toLocalDate().getYear() + " " + make + " " + model;
  }

  public ArrayList<String> getAllValues() {
    return new ArrayList<String>(Arrays.asList(numberPlates,
        make, model, bodyType, String.valueOf(km), yor.toLocalDate().toString(),
        String.valueOf(kmpl), drive, String.valueOf(weight), engineType, String.valueOf(volume),
        String.valueOf(cyl), String.valueOf(hp), String.valueOf(gearbox), String.valueOf(hybrid)));
  }
}

package com.ib315168.bilertool.model;

import java.sql.Date;
import java.time.LocalDate;
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
    set(numberPlates, make, model, bodyType, km, yor, kmpl, drive, weight,
        engineType, volume, cyl, hp, gearbox, hybrid);
  }

  private void set(String numberPlates, String make, String model, String bodyType,
      int km, Date yor, double kmpl, String drive, int weight,
      String engineType, int volume, int cyl, int hp, boolean gearbox,
      boolean hybrid) {
    if(numberPlates == null || numberPlates.isBlank() || numberPlates.length()!=7) {
      throw new IllegalArgumentException("Incorrect number plates");
    }
    this.numberPlates = numberPlates;

    if(make == null || make.isBlank()) {
      throw new IllegalArgumentException("Incorrect make");
    }
    this.make = make;

    if(model == null || model.isBlank()) {
      throw new IllegalArgumentException("Incorrect model");
    }
    this.model = model;

    if(bodyType == null || bodyType.isBlank()) {
      throw new IllegalArgumentException("Incorrect body type");
    }
    this.bodyType = bodyType;

    if(km < 0) {
      throw new IllegalArgumentException("Incorrect mileage");
    }
    this.km = km;

    if(yor == null || yor.after(Date.valueOf(LocalDate.now()))) {
      throw new IllegalArgumentException("Incorrect date");
    }
    this.yor = yor;

    if(kmpl < 0.0) {
      throw new IllegalArgumentException("Incorrect km/l");
    }
    this.kmpl = kmpl;

    if(drive == null || drive.isBlank() || !(drive.equals("FWD") || drive.equals("RWD") || drive.equals("AWD"))) {
      throw new IllegalArgumentException("Incorrect drive (FWD/RWD/AWD)");
    }
    this.drive = drive;

    if(weight < 0) {
      throw new IllegalArgumentException("Incorrect weight");
    }
    this.weight = weight;

    if(engineType == null || engineType.isBlank() || !(engineType.equals("Petrol") || engineType.equals("Diesel") || engineType.equals("Electric"))) {
      throw new IllegalArgumentException("Incorrect engine type (Petrol/Diesel/Electric)");
    }
    this.engineType = engineType;

    if(volume < 0) {
      throw new IllegalArgumentException("Incorrect volume");
    }
    this.volume = volume;

    if(cyl < 0) {
      throw new IllegalArgumentException("Incorrect amount of cylinders");
    }
    this.cyl = cyl;

    if(hp < 0) {
      throw new IllegalArgumentException("Incorrect amount of horsepower");
    }
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

  public String getDifferences(Bil bil) {
    String differences = "";
    for(int i = 0; i < getAllValues().size(); i++) {
      if(!getAllValues().get(i).equals(bil.getAllValues().get(i))) {
        differences += "new: " + getAllValues().get(i) + " old: " + bil.getAllValues().get(i) + "\n";
      }
    }
    return differences;
  }
}

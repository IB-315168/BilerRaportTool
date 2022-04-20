package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Model;

public class ViewModelFactory
{
  private final BilerViewModel bilerViewModel;

  public ViewModelFactory(Model model) {
    this.bilerViewModel = new BilerViewModel(model);
  }

  public BilerViewModel getBilerViewModel()
  {
    return bilerViewModel;
  }
}

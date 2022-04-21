package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Model;

public class ViewModelFactory
{
  private final BilerViewModel bilerViewModel;
  private final AddViewModel addViewModel;

  public ViewModelFactory(Model model) {
    this.bilerViewModel = new BilerViewModel(model);
    this.addViewModel = new AddViewModel(model);
  }

  public BilerViewModel getBilerViewModel()
  {
    return bilerViewModel;
  }
  public AddViewModel getAddViewModel() { return addViewModel; }
}

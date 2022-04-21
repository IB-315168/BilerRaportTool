package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Model;

public class ViewModelFactory
{
  private final BilerViewModel bilerViewModel;
  private final AddViewModel addViewModel;
  private final LoginViewModel loginViewModel;

  public ViewModelFactory(Model model) {
    this.bilerViewModel = new BilerViewModel(model);
    this.addViewModel = new AddViewModel(model);
    this.loginViewModel = new LoginViewModel(model);
  }

  public BilerViewModel getBilerViewModel()
  {
    return bilerViewModel;
  }
  public AddViewModel getAddViewModel() { return addViewModel; }
  public LoginViewModel getLoginViewModel() { return loginViewModel; }
}

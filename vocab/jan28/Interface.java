class Interface implements dasInterfacen {
  static int it = 3;
  static double dit = 8;

  static int fit(int i, double d) {
    dit = i;
    it = (int) d;
    if(dit>it) return (int)(i / d);
    return (int)(d / i);
  }

  static void bit(double i, int d) {
    dit = i;
    it =  d;
    dit = fit((int)dit, it);
    it = fit((int)dit, it);
  }
}

interface dasInterfacen {
  int fit(int d,double i);
  void bit(double i,int d);
}
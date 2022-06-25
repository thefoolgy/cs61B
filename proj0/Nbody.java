public class Nbody{
	
	public static void main(String[] args){
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setXscale(-r,r);
		StdDraw.setYscale(-r,r);
		StdDraw.enableDoubleBuffering();
		double t = 0;
		int num = planets.length;
		while ( t <= T){
			double[] xForces = new double[num];
			double[] yForces = new double[num];
			for (int i = 0; i < num; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < num; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for (Planet p: planets){
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			t += dt;

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}			
		}


		}

		public static double readRadius(String filename){
			In in = new In(filename);
			int N = in.readInt();
			double r = in.readDouble();
			return r;
		}

		public static Planet[] readPlanets(String filename){
			In in = new In(filename);
			int N = in.readInt();
			double R = in.readDouble();
			Planet[] planets = new Planet[N];
			for (int i = 0; i < N; i++){
				double xxPos = in.readDouble();
				double yyPos = in.readDouble();
			 	double xxVel = in.readDouble();
			 	double yyVel = in.readDouble();
			 	double mass = in.readDouble();
			 	String img = in.readString();
			 	planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
			}
			return planets;			
		}
		

}
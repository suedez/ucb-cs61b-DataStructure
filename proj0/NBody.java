public class NBody{

	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int NofPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName) { //be careful of 'Planet[]'
		In in  = new In(fileName);
		int NofPlanets = in.readInt();
		double radius = in.readDouble();
		Planet[] p = new Planet[NofPlanets];//rememver'[]'declears the length of array
		for(int i = 0; i < NofPlanets; i += 1) { //remember this '! in.isEmpty'
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			p[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return p;
	}

	public static void main(String[] args) {

		/**collecting all needed input*/
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double universeR = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		//System.out.println(planets); used for checking

		/**draw the background
		1.give the image that is going to be background
		2.set up the scale
		3.clear ths drawing window
		4.put the background picture on the center
		5.show your drawing and(optional) give a puasing time*/
	    String imgToDraw = "images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-universeR, universeR);
		StdDraw.clear();//clear the drawing window
		StdDraw.picture(0, 0, imgToDraw);
		StdDraw.show();

		/**draw planets*/
		for(int i = 0; i < planets.length; i += 1) {
			Planet p = planets[i];
			p.draw();
		}
		StdDraw.pause(2000);//pause 2s for the initial pic.

		/**animate the synamic universe
		attention: you should go to next dt after updating all N planets(i.e. seperate the loop)*/
		for(double t = 0; t < T; t += dt) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i += 1) {
				Planet p = planets[i];
				xForces[i] = p.calcNetForceExertedByX(planets);
				yForces[i] = p.calcNetForceExertedByY(planets);	
			}
			StdDraw.picture(0, 0, imgToDraw);
			for(int i = 0; i < planets.length; i += 1) {
				planets[i].update(dt, xForces[i], yForces[i]);
				planets[i].draw();
			}
				StdDraw.show();	
				StdDraw.pause(10);//10 milliseconds(1000milliseconds = 1 s)			
		}

		/**print out the results in a data form*/
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", universeR);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}




















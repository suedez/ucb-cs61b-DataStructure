public class Planet {

	/**the variables must be first decleared(remember int double etc.)*/
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	Double mass;
	String imgFileName;
	public static double G = 6.67 * Math.pow(10, -11);//Math.pow(x,2)
	
	public 	Planet(double xP, double yP, double xV, double yV, double m, String img){
		
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public 	Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}

	/**calculate forces exerted by a single planet*/
	public double calcForceExertedBy(Planet p){
		double force = this.mass * p.mass * G /(this.calcDistance(p) * this.calcDistance(p));//rememer "this.calcDistance"
		return force;
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		double forceX = this.calcForceExertedBy(p) * dx/this.calcDistance(p);
		return forceX;
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		double forceY = this.calcForceExertedBy(p) * dy/this.calcDistance(p);
		return forceY; 
	}

	/**calculate net force on x and y*/
	public double calcNetForceExertedByX(Planet[] p){
		double netForceX = 0;
		for(int i = 0; i < p.length; i += 1){
			if(this.equals(p[i])) {
				continue;
			}
			netForceX = netForceX + this.calcForceExertedByX(p[i]);
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Planet[] p){
		double netForceY = 0;
		for(int i = 0; i < p.length; i += 1){
			if(this.equals(p[i])) {
				continue;
			}
			netForceY = netForceY + this.calcForceExertedByY(p[i]);
		}
		return netForceY;	
	}

	/**这里不是很懂。。。this.xxVel += dt * accX*/
	public void update(double dt, double fX, double fY){
		double accX = fX/this.mass;//acceleration on x direction
		double accY = fY/this.mass;
		this.xxVel = this.xxVel + dt * accX;
		this.yyVel = this.yyVel + dt * accY;
		this.xxPos = this.xxPos + dt * xxVel;
		this.yyPos = this.yyPos + dt * yyVel;
	}

	public void draw(){
		StdDraw.enableDoubleBuffering();
		String imgToDraw = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, imgToDraw);
		StdDraw.show();
	}
}























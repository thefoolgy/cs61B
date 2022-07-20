public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double gravitation = 6.67e10-11;

	public Planet(double xP, double yP, double xV, 
					double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		return Math.sqrt(
			(this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos)
			);
	}
	public double calcForceExertedBy(Planet p){
		return (gravitation * this.mass * p.mass)/(calcDistance(p)*calcDistance(p));
	}
	public double calcForceExertedByX(Planet p){
		
		return (this.calcForceExertedBy(p)*(p.xxPos - this.xxPos))/this.calcDistance(p);
		
	}
	public double calcForceExertedByY(Planet p){
		
		return (this.calcForceExertedBy(p)*(p.yyPos - this.yyPos))/this.calcDistance(p);
		
	}	
	public double calcNetForceExertedByX(Planet[] allPlanets){
		int i = 0;
		double sum = 0;
		while (i < allPlanets.length){
			if (this.equals(allPlanets[i])){
				continue;
			}
			sum = sum + calcForceExertedByX(allPlanets[i]);
			i += 1;
		}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
		int i = 0;
		double sum = 0;
		while (i < allPlanets.length){
			if (this.equals(allPlanets[i])){
				continue;
			}
			sum = sum + calcForceExertedByY(allPlanets[i]);
			i += 1;
		}
		return sum;
	}
	public void update(double dt, double fX, double fY){
		this.xxVel = this.xxVel + dt * (fX/this.mass);
		this.yyVel = this.yyVel + dt * (fY/this.mass);
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}
enum Direction {
	UP(0, 1),
	DOWN(0, -1),
	LEFT(-1, 0),
	RIGHT(1, 0);

	private final int dx;
	private final int dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Direction turnLeft() {
		switch (this) {
			case UP:
				return LEFT;
			case DOWN:
				return RIGHT;
			case LEFT:
				return DOWN;
			case RIGHT:
				return UP;
			default:
				throw new IllegalStateException();
		}
	}

	public Direction turnRight() {
		switch (this) {
			case UP:
				return RIGHT;
			case DOWN:
				return LEFT;
			case LEFT:
				return UP;
			case RIGHT:
				return DOWN;
			default:
				throw new IllegalStateException();
		}
	}

	public int dx() {
		return dx;
	}

	public int dy() {
		return dy;
	}
}
//Don't change code below

class Move {
	public static void main(String[] args) {
		Robot robot = new Robot(0, 0, Direction.UP);
		Move.moveRobot(robot, 3, 0);
		System.out.println(robot.getX() + " " + robot.getY());
	}

	public static void moveRobot(Robot robot, int toX, int toY) {
		while (robot.getX() != toX) {
			// need to go left
			if (robot.getX() > toX) {
				while (robot.getDirection() != Direction.LEFT) {
					if (robot.getDirection() == Direction.UP) {
						robot.turnLeft();
					} else {
						robot.turnRight();
					}
				}
			} else {
				// need to go right
				while (robot.getDirection() != Direction.RIGHT) {
					if (robot.getDirection() == Direction.DOWN) {
						robot.turnLeft();
					} else {
						robot.turnRight();
					}
				}
			}
			robot.stepForward();
		}
		while (robot.getY() != toY) {
			// need to go down
			if (robot.getY() > toY) {
				while (robot.getDirection() != Direction.DOWN) {
					if (robot.getDirection() == Direction.LEFT) {
						robot.turnLeft();
					} else {
						robot.turnRight();
					}
				}
			} else {
				// need to go up
				while (robot.getDirection() != Direction.UP) {
					if (robot.getDirection() == Direction.RIGHT) {
						robot.turnLeft();
					} else {
						robot.turnRight();
					}
				}
			}
			robot.stepForward();
		}
	}
}

class Robot {
	private int x;
	private int y;
	private Direction direction;

	public Robot(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void turnLeft() {
		direction = direction.turnLeft();
	}

	public void turnRight() {
		direction = direction.turnRight();
	}

	public void stepForward() {
		x += direction.dx();
		y += direction.dy();
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
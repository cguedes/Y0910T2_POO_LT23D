package game;

import common.Point;

public interface BoundaryProvider 
{
	boolean isInside(Point pos);
}

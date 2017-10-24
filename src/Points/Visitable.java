package Points;

import Points.Visitor;

public interface Visitable{
    public int accept(Visitor visitor);
}

package Points;

public interface Visitor {

    public abstract int visit(Goal goalBonus);
    public abstract int visit(Assist assistBonus);
    public abstract int visit(CleanSheet csBonus);
}


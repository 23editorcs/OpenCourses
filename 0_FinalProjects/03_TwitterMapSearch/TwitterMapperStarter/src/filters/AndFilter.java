package filters;

import com.sun.deploy.util.ArrayUtil;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {

    private final Filter firstChild;
    private final Filter secondChild;

    public AndFilter(Filter firstChild, Filter secondChild) {
        this.firstChild = firstChild;
        this.secondChild = secondChild;
    }


    @Override
    public boolean matches(Status s) {
        return firstChild.matches(s) && secondChild.matches(s);
    }

    @Override
    public List<String> terms() {
        List<String> ans = new ArrayList<>();
        ans = firstChild.terms();
        ans.addAll(secondChild.terms());
        return ans;
    }

    @Override
    public String toString() {
        return "(" + firstChild.toString() + " and " + secondChild.toString() + ")";
    }
}

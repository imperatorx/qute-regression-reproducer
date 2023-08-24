package foo;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("")
public class FooResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(TemplateClass item);
    }

    @Path("")
    @GET
    public TemplateInstance index() {
        return Templates.index(new TemplateClass(1, null));
    }

    public enum MyEnum {
        A, B
    }

    public static class TemplateClass {

        private final int id;
        private final MyEnum myEnum;

        public TemplateClass(int id, MyEnum myEnum) {
            this.id = id;
            this.myEnum = myEnum;
        }

        public int getId() {
            return id;
        }

        public MyEnum getMyEnum() {
            return myEnum;
        }
    }

}

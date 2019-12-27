package prac.chapter02.create_destroy;

public class SampleClass {
    private static SampleClass sampleClass;
    private Long id;
    private String name;

    private SampleClass() {
    }

    private SampleClass(Long id) {
        this.id = id;
    }

    private SampleClass(String name) {
        this.name = name;
    }

    private SampleClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SampleClass newSampleClass() {
        sampleClass = new SampleClass();
        return sampleClass;
    }

    public static SampleClass newSampleClassById(Long id) {
        sampleClass = new SampleClass(id);
        return sampleClass;
    }

    public static SampleClass newSampleClassByName(String name) {
        sampleClass = new SampleClass(name);
        return sampleClass;
    }

    public static SampleClass newSampleClassByIdName(Long id, String name) {
        if(sampleClass == null) {   // singleton test
            sampleClass = new SampleClass(id, name);
        }
        
        return sampleClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public String toString() {
    //     return "id : "+id+" , name : "+name;
    // }

}
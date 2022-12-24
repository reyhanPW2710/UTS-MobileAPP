package id.ac.umn.uts_00000042578_ReyhanPhilliesWijaya;

public class Item {
    private int mImageResource, link;
    private String judul, desc;

    public Item(int imageResource, String judulVideo, String descVideo, int linkVideo) {
        mImageResource = imageResource;
        judul = judulVideo;
        desc = descVideo;
        link = linkVideo;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return judul;
    }

    public String getText2() {
        return desc;
    }

    public int getText3() {
        return link;
    }

}

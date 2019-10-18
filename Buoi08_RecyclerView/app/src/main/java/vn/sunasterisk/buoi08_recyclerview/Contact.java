package vn.sunasterisk.buoi08_recyclerview;

public class Contact {
    private int mAvatarId;
    private String mName;
    private String mPhone;

    public Contact() {
    }

    public Contact(int avatarId, String name, String phone) {
        mAvatarId = avatarId;
        mName = name;
        mPhone = phone;
    }

    public int getAvatarId() {
        return mAvatarId;
    }

    public void setAvatarId(int avatarId) {
        mAvatarId = avatarId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }
}

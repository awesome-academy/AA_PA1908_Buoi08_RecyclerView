package vn.sunasterisk.buoi08_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> mContacts;

    private OnItemClickListeners mClickListeners;

    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    public void setClickListeners(OnItemClickListeners clickListeners) {
        mClickListeners = clickListeners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // anh xa item_contact vao view
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_contact,
                        parent,
                        false
                );

        // tra ve mot ViewHolder moi
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.mImageAvatar.setImageResource(contact.getAvatarId());
        holder.mTextName.setText(contact.getName());
        holder.mTextPhone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        // neu mContacts null thi tra ve 0, nguoc lai tra ve size
        return mContacts == null ? 0 : mContacts.size();
    }

    // tao ra 1 class ViewHolder ke thua tu ViewHolder cua RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private ConstraintLayout mLayoutContact;
        private ImageView mImageAvatar;
        private TextView mTextName;
        private TextView mTextPhone;
        private ImageButton mButtonRemove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageAvatar = itemView.findViewById(R.id.image_avatar);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextPhone = itemView.findViewById(R.id.text_phone);
            mLayoutContact = itemView.findViewById(R.id.layout_contact);
            mButtonRemove = itemView.findViewById(R.id.button_remove);

            mLayoutContact.setOnClickListener(this);
            mButtonRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_remove:
                    mClickListeners.onItemRemove(getAdapterPosition());
                    break;
                case R.id.layout_contact:
                    //todo
                    int position = getAdapterPosition();
                    mClickListeners.onItemClick(mContacts.get(position), position);
                    break;
                default:
                    break;
            }
        }
    }

    public void addContacts(List<Contact> contacts) {
        mContacts = contacts;
    }

    public void removeContact(int position){
        mContacts.remove(position);
        //notifyDataSetChanged();
        notifyItemRemoved(position);
    }

    public interface OnItemClickListeners {
        void onItemRemove(int position);

        void onItemClick(Contact contact, int position);
    }

}

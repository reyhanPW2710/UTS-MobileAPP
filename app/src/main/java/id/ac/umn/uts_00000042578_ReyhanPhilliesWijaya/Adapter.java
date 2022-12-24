package id.ac.umn.uts_00000042578_ReyhanPhilliesWijaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final VideoInterface videoInterface;

    Context context;
    private ArrayList<Item> mList;
    private View.OnClickListener mListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView, mImageView1;
        public TextView mTextView1;

        public ViewHolder(View itemView, VideoInterface videoInterface) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mImageView1 = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(videoInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            videoInterface.onItemClick(pos);
                        }
                    }
                }
            });

            mImageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(videoInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            videoInterface.onDeleteClick(pos);
                        }
                    }
                }
            });
        }
    }

    public Adapter(Context context, ArrayList<Item> List, VideoInterface videoInterface) {
        this.context = context;
        this.mList = List;
        this.videoInterface = videoInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder evh = new ViewHolder(view, videoInterface);
        return evh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item currentItem = mList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

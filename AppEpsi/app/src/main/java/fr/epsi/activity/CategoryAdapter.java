package fr.epsi.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Category;
import fr.epsi.entity.Student;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private ArrayList<Category> categories;
    private MainActivity activity;

    public CategoryAdapter(MainActivity activity, ArrayList<Category> categories){
        this.activity=activity;
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category= categories.get(position);
        holder.getEmail().setText(student.getEmail());
        Picasso.get().load(student.getUrl()).into(holder.getPicture());
        holder.getGroup().setText(student.getGroup());
        holder.getWebsite().setText(student.getWebsite());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView category_id;
        private final TextView title;
        private final TextView products_url;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            category_id = (TextView) view.findViewById(R.id.textViewCategory_id);
            title = (TextView) view.findViewById(R.id.textViewCategory_title);
            products_url = (TextView) view.findViewById(R.id.imageViewProducts_url);
        }

        public TextView getCategoryId() {
            return category_id;
        }
        public TextView getTitle() {
            return title;
        }
        public TextView getProductsUrl() {
            return products_url;
        }
    }
}
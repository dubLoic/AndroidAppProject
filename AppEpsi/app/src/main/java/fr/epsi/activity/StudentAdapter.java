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
import fr.epsi.entity.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    private ArrayList<Student> students;
    private MainActivity activity;

    public StudentAdapter(MainActivity activity, ArrayList<Student> students){
        this.activity=activity;
        this.students=students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_student, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student=students.get(position);
        holder.getName().setText(student.getName());
        holder.getEmail().setText(student.getEmail());
        Picasso.get().load(student.getUrl()).into(holder.getPicture());
        holder.getGroup().setText(student.getGroup());
        holder.getWebsite().setText(student.getWebsite());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView email;
        private final ImageView picture;
        private final TextView group;
        private final TextView website;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            name = (TextView) view.findViewById(R.id.textViewName);
            email = (TextView) view.findViewById(R.id.textViewEmail);
            picture = (ImageView) view.findViewById(R.id.imageViewPicture);
            group = (TextView) view.findViewById(R.id.textViewGroup);
            website = (TextView) view.findViewById(R.id.textViewWebsite);
        }

        public TextView getName() {
            return name;
        }
        public TextView getEmail() {
            return email;
        }
        public ImageView getPicture() {
            return picture;
        }
        public TextView getGroup() {
            return name;
        }
        public TextView getWebsite() {
            return email;
        }
    }
}
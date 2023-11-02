import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class runListView extends BaseAdapter {
    private Context context;
    private ArrayList<item> items;

    public runListView(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);  // returns item at that location
    }

    @Override
   f public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_view_row_items, parent, false);
        }
        // get current item
        Item currentItem = (Item) getItem(posotion);

        // now get the text view
        TextView textViewItemName = (TextView)  convertView.findViewById(R.id.text_view_item_name);
        TextView textViewItemHeight = (TextView)  convertView.findViewById(R.id.text_view_item_height);
        TextView textViewItemMass = (TextView)  convertView.findViewById(R.id.text_view_item_mass);

        // set it
        textViewItemName.setText(currentItem.getItemName());
        textViewItemHeight.setText(currentItem.getItemHeight());
        textViewItemMass.setText(currentItem.getItemMass());

        return convertView;
        }
    }
}

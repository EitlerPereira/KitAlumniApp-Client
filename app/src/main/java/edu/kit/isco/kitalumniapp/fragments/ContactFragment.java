package edu.kit.isco.kitalumniapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.kit.isco.kitalumniapp.Contact;
import edu.kit.isco.kitalumniapp.R;
import edu.kit.isco.kitalumniapp.adapter.ExpandableListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    ArrayList<Contact> contacts;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Contact> arrayOfUsers = new ArrayList<Contact>();
        // Create the adapter to convert the array to views
        //ContactsAdapter adapter = new ContactsAdapter(getActivity(), arrayOfUsers);
        //prepareListData();
        prepareData();
        ExpandableListAdapter adapter = new ExpandableListAdapter(getActivity(), contacts);

        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        //ListView listView = (ListView) view.findViewById(R.id.contactListView);
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.contactListView);
        //ListView listView = (ListView) this.getActivity().findViewById(R.id.contactListView);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String txt =  ((TextView) v.findViewById(R.id.infotext)).getText().toString();

                switch ((int)id) {
                    case 0:
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", txt , null));
                        startActivity(Intent.createChooser(emailIntent, getActivity().getString(R.string.sendEmail)));
                        break;
                    case 1:
                        if (!txt.startsWith("http://") && !txt.startsWith("https://"))
                            txt = "http://" + txt;
                        Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                        websiteIntent.setData(Uri.parse(txt));
                        startActivity(Intent.createChooser(websiteIntent, getActivity().getString(R.string.openSite)));
                        break;
                    case 2:
                        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                        phoneIntent.setData(Uri.parse("tel:" + txt));
                        startActivity(phoneIntent);
                        break;
                    default:
                        break;
                }
                //Toast.makeText(getActivity().getApplicationContext(), "child:" + childPosition + " id:" + id, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setAdapter(adapter);
        return view;
    }

    private void prepareData(){
        contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Test2", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", null, "www.web.de"));
        contacts.add(new Contact("Fikitv ", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", "muster@mann.org", "www.muster.man"));
        contacts.add(new Contact("BlueFanta", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", null, "www.web.de"));
        contacts.add(new Contact("Test2", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", null, "www.web.de"));
        contacts.add(new Contact("Test2", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", null, "www.web.de"));
        contacts.add(new Contact("Test2", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", null, "www.web.de"));
        contacts.add(new Contact("Test2", "Balblalsalkdslafdsfjdslfjlsdjf", "0172345678", null, "www.web.de"));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

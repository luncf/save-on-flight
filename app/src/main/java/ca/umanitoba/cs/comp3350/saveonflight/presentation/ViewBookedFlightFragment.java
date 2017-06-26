package ca.umanitoba.cs.comp3350.saveonflight.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.umanitoba.cs.comp3350.saveonflight.R;
import ca.umanitoba.cs.comp3350.saveonflight.business.AccessBookedFlights;
import ca.umanitoba.cs.comp3350.saveonflight.business.AccessBookedFlightsImpl;
import ca.umanitoba.cs.comp3350.saveonflight.objects.BookedFlight;
import ca.umanitoba.cs.comp3350.saveonflight.objects.Flight;
import ca.umanitoba.cs.comp3350.saveonflight.objects.Traveller;

public class ViewBookedFlightFragment extends ListFragment {
    private TextView tvPassenger;

    private ArrayList<Flight> flights;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        View view = inflater.inflate(R.layout.fragment_view_bookedflight, container, false);
        tvPassenger = (TextView) view.findViewById(R.id.textView_passenger_id);
        // TODO: get passenger id and update the textview
        final int PASSENGER_ID = 1;
        // TODO: get all booked flights associated with this passenger
        AccessBookedFlights accessBookedFlights = new AccessBookedFlightsImpl();

        // TODO: get all flights
        ArrayList<BookedFlight> bfs = accessBookedFlights.searchByTraveller(new Traveller(PASSENGER_ID, null));
        flights = new ArrayList<>();
        for (BookedFlight bf : bfs) {
            flights.add(bf.getFlight());
        }

        return view;
    }

}

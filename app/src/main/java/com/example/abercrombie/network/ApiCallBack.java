package com.example.abercrombie.network;

import com.example.abercrombie.data.Explorative;

import java.util.List;

/**
 * A callback for retrieving the API response.
 */
public interface ApiCallBack {
    void sendData(List<Explorative> list);
}

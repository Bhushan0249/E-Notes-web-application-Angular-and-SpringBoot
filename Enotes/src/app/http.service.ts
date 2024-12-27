import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  private baseUrl = 'http://localhost:8080/api/'; // Adjust according to your backend URL

  constructor(private http: HttpClient) {}

  postMapping(obj: any) {
    return this.http.post(`${this.baseUrl}addNotes`, obj, {
      responseType: 'text',
    });
  }

  getAllNotes(id: any) {
    return this.http.get(`${this.baseUrl}getNotes/${id}`);
  }

  addUser(obj: any) {
    return this.http.post(`${this.baseUrl}adduser`, obj, {
      responseType: 'text',
    });
  }

  getNotesById(id: any) {
    return this.http.get(`${this.baseUrl}getnotes/${id}`);
  }

  updateNotesData(obj: any) {
    return this.http.put(`${this.baseUrl}upNotes/${obj.nid}`, obj, {
      responseType: 'text',
    });
  }

  deleteData(nid: any) {
    return this.http.delete(`${this.baseUrl}deleteNotes/${nid}`, {
      responseType: 'text',
    });
  }
}

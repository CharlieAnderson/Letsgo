package com.example.charlesanderson.letsgo.database;

public abstract class FirebaseRepository<Model> {
//
//        protected DatabaseReference databaseReference;
//        protected FirebaseRepositoryCallback<Model> firebaseCallback;
//        private BaseValueEventListener listener;
//        private FirebaseMapper mapper;
//
//        protected abstract String getRootNode();
//
//        public FirebaseRepository(FirebaseMapper mapper) {
//            databaseReference = FirebaseDatabase.getInstance().getReference(getRootNode());
//            this.mapper = mapper;
//        }
//
//        public void addListener(FirebaseRepositoryCallback<Model> firebaseCallback) {
//            this.firebaseCallback = firebaseCallback;
//            listener = new BaseValueEventListener(mapper, firebaseCallback);
//            databaseReference.addValueEventListener(listener);
//        }
//
//        public void removeListener() {
//            databaseReference.removeEventListener(listener);
//        }
//
//        public interface FirebaseRepositoryCallback<T> {
//            void onSuccess(List<T> result);
//
//            void onError(Exception e);
//        }
}

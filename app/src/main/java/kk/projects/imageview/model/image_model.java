package kk.projects.imageview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class image_model {


    private List<image_model.ResponseItem> response;

    public List<image_model.ResponseItem> getResponse() {
        return response;
    }


    public class ResponseItem {


        @SerializedName("id")
        private String id;

        @SerializedName("alt_description")
        private String alt_description;

        public String getId() {
            return id;
        }


        public String getAlt_description() {
            return alt_description;
        }



        @SerializedName("urls")
        private image_model.ResponseItem.urls urls;

        public ResponseItem.urls getUrls() {
            return urls;
        }

        public class urls {

            @SerializedName("small")
            private String small;


            @SerializedName("small_s3")
            private String small_s3;

            public String getSmall() {
                return small;
            }

            public String getSmall_s3() {
                return small_s3;
            }
        }

    }

}

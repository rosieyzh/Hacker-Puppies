#!/usr/bin/env python
# coding: utf-8

# In[1]:


from flask import Flask,request
app = Flask(__name__)

from flask_cors import CORS
CORS(app)
import tensorflow as tf
import keras
from keras.models import load_model
import re
import pickle
import numpy as np
from keras.preprocessing import image
from keras.applications.inception_resnet_v2 import preprocess_input, decode_predictions
from tensorflow.keras import Model
from tensorflow.keras.layers import Input, Dense
from tensorflow.keras.applications.inception_resnet_v2 import InceptionResNetV2


# In[2]:


with open('encoder.pkl','rb') as f:
    one_hot = pickle.load(f)
    f.close()


# In[3]:


def create_model():
    global model
    model = load_model('model.h5')
    model._make_predict_function()


# In[4]:


def preprocess_image(img):
    Image = image.load_img("train/" + img + ".jpg", target_size=(299, 299))
    data = image.img_to_array(Image)
    data = preprocess_input(data)
    return data


# In[5]:


def un_onehot(data):
    breed = one_hot.inverse_transform(data)
    return breed


# In[6]:


one_hot


# In[7]:


@app.route('/upload',methods=['GET'])
def upload_file():
    file = request.files['image']
    x = preprocess_image(file)
    breed = model.predict(x)
    label = un_onehot(breed)
    return json.dumps(dict("breed:", label))


# In[ ]:





# In[8]:


if __name__ == '__main__':
    create_model()
    app.run(debug = True)


# In[ ]:





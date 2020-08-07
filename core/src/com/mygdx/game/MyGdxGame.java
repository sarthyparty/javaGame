package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.sql.SQLException;

import services.*;

public class MyGdxGame implements ApplicationListener {
	private float SpriteX=0;
	private float SpriteY=0;
	private float SpriteSpeed=50.0f;

	SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation<TextureRegion> animation;
	private float elapsedTime = 0;
	private Connecter connection;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/spritesheet.atlas"));
		animation = new Animation(1/15f, textureAtlas.getRegions());
		/*
		try {
			connection = new Connecter();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {

		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
			SpriteX -= Gdx.graphics.getDeltaTime() *SpriteSpeed;
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
			SpriteX += Gdx.graphics.getDeltaTime() * SpriteSpeed;
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
			SpriteY += Gdx.graphics.getDeltaTime() * SpriteSpeed;
		if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
			SpriteY -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), (int)SpriteX, (int) SpriteY);
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
	}
}
